package com.sfac.springBoot.modules.traffic.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.ResultEntity.ResultStatus;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.dao.ParkingChargeDao;
import com.sfac.springBoot.modules.traffic.dao.ParkingSpaceDao;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge.ParkingChargeType;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace.ParkingSpaceStatus;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace.ParkingSpaceType;
import com.sfac.springBoot.modules.traffic.service.ParkingChargeService;
import com.sfac.springBoot.util.DateTimeUtil;

/**
 * Description: Parking Charge Service Impl
 * @author HymanHu
 * @date 2021-03-22 16:38:12
 */
@Service
public class ParkingChargeServiceImpl implements ParkingChargeService {
	
	@Autowired
	private ParkingChargeDao parkingChargeDao;
	@Autowired
	private ParkingSpaceDao parkingSpaceDao;

	@Override
	@Transactional
	public ResultEntity<ParkingCharge> insertParkingCharge(ParkingCharge parkingCharge) {
		// 判断车位是否已满
		List<ParkingSpace> parkingSpaces = Optional
				.ofNullable(parkingSpaceDao.getParkingSpacesByStatus(ParkingSpaceStatus.IDLE.status))
				.orElse(Collections.emptyList());
		if (parkingSpaces.size() == 0) {
			return new ResultEntity<ParkingCharge>(ResultStatus.FAILED.status, "车位已满，无法进场。");
		}
		
		/**
		 * - 逻辑一：会员车辆指定固定车位，车辆进场检查是否会员，是否有固定车位
		 * - 逻辑二：会员不指定固定车位，车辆进场随机指定空闲车位
		 * - 此处按逻辑二处理
		 */
		if (parkingCharge.getChargeType() == ParkingChargeType.TEMPORARY_STOP.code) {
			ParkingSpace parkingSpace = parkingSpaces.get(new Random().nextInt(parkingSpaces.size()));
			parkingSpace.setStatus(ParkingSpaceStatus.USED.status);
			parkingSpaceDao.updateParkingSpace(parkingSpace);
			parkingCharge.setParkingId(parkingSpace.getId());
		}
		
		parkingCharge.setCreateDate(LocalDateTime.now());
		parkingChargeDao.insertParkingCharge(parkingCharge);
		return new ResultEntity<ParkingCharge>(ResultStatus.SUCCESS.status, "Insert success.", parkingCharge);
	}

	@Override
	@Transactional
	public ResultEntity<ParkingCharge> updateParkingCharge(ParkingCharge parkingCharge) {
		parkingChargeDao.updateParkingCharge(parkingCharge);
		// 车位变更状态
		ParkingSpace parkingSpace = parkingSpaceDao.getParkingSpaceById(parkingCharge.getParkingId());
		parkingSpace.setStatus(ParkingSpaceStatus.IDLE.status);
		parkingSpaceDao.updateParkingSpace(parkingSpace);
		return new ResultEntity<ParkingCharge>(ResultStatus.SUCCESS.status, "Update success.", parkingCharge);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteParkingCharge(int id) {
		parkingChargeDao.deleteParkingCharge(id);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public ParkingCharge getParkingChargeById(int id) {
		return parkingChargeDao.getParkingChargeById(id);
	}

	@Override
	public PageInfo<ParkingCharge> getParkingChargesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<ParkingCharge>(
				Optional.ofNullable(parkingChargeDao.getParkingChargesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

	@Override
	public ResultEntity<ParkingCharge> calculateParkingCharge(ParkingCharge parkingCharge) {
		if (parkingCharge.getEnd().isBefore(parkingCharge.getStart())) {
			return new ResultEntity<ParkingCharge>(
					ResultStatus.FAILED.status, "结束时间应在开始时间之后。");
		}
		
		// 查询数据库时间重叠记录
		List<ParkingCharge> parkingCharges = Optional
				.ofNullable(parkingChargeDao.getRepeatParkingCharges(
						parkingCharge.getStart(), 
						parkingCharge.getEnd(), 
						parkingCharge.getCarLicense()))
				.orElse(Collections.emptyList());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (parkingCharge.getChargeType() == ParkingChargeType.LONG_TIME_STOP.code) {
			if (!parkingCharges.isEmpty()) {
				return new ResultEntity<ParkingCharge>(
						ResultStatus.FAILED.status, 
						String.format("缴费时间重复，请从 %s 后开始缴费。", dtf.format(parkingCharges.get(0).getEnd())));
			}
			Duration duration = Duration.between(parkingCharge.getStart(), parkingCharge.getEnd());
			parkingCharge.setSum((duration.toMillis() % 60) > 0 ? (int)duration.toHours() + 1 : (int)duration.toHours());
//			parkingCharge.setFee(ParkingChargeType.LONG_TIME_STOP.unitPrice * duration.toHours());
			parkingCharge.setFee(new Random().nextInt(10));
			return new ResultEntity<ParkingCharge>(
					ResultStatus.SUCCESS.status, "计费成功。", parkingCharge);
		} else {
			// 将临停时间段和该车牌号会员缴费时间做交集，计算出重叠总时间
			int overlappingTime = parkingCharges.stream()
				.map(item -> 
					DateTimeUtil.calculateOverlappingTime(
							item.getStart(), item.getEnd(), 
							parkingCharge.getStart(), parkingCharge.getEnd()))
				.reduce((i, j) -> i + j)
				.orElse(0);
			
			// 设置总停车时间
			Duration duration = Duration.between(parkingCharge.getStart(), parkingCharge.getEnd());
			int sum = (duration.toMinutes() % 60) > 0 ? (int)duration.toHours() + 1 : (int)duration.toHours();
			parkingCharge.setSum(sum);
			// 根据停车位和时间计算价格，计费时间要减去会员缴费重叠时间
			ParkingSpace parkingSpace = parkingSpaceDao.getParkingSpaceById(parkingCharge.getParkingId());
			ParkingSpaceType parkingSpaceType = 
					ParkingSpaceType.getParkingSpaceTypeByName(parkingSpace.getParkingSpaceType());
			double fee = (sum - overlappingTime) >= 4 ? 
					parkingSpaceType.headFourHoursPrice + parkingSpaceType.preHourPrice * ((sum - overlappingTime) - 4) : 
					((sum - overlappingTime) > 0 ? parkingSpaceType.headFourHoursPrice : 0);
			parkingCharge.setFee(fee);
			
			return new ResultEntity<ParkingCharge>(
					ResultStatus.SUCCESS.status, "计费成功。", parkingCharge);
		}
	}
}
