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
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge.ParkingChargeType;
import com.sfac.springBoot.modules.traffic.service.ParkingChargeService;

/**
 * Description: Parking Charge Service Impl
 * @author HymanHu
 * @date 2021-03-22 16:38:12
 */
@Service
public class ParkingChargeServiceImpl implements ParkingChargeService {
	
	@Autowired
	private ParkingChargeDao parkingChargeDao;

	@Override
	@Transactional
	public ResultEntity<ParkingCharge> insertParkingCharge(ParkingCharge parkingCharge) {
		parkingCharge.setCreateDate(LocalDateTime.now());
		parkingChargeDao.insertParkingCharge(parkingCharge);
		return new ResultEntity<ParkingCharge>(ResultStatus.SUCCESS.status, "Insert success.", parkingCharge);
	}

	@Override
	@Transactional
	public ResultEntity<ParkingCharge> updateParkingCharge(ParkingCharge parkingCharge) {
		parkingChargeDao.updateParkingCharge(parkingCharge);
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<ParkingCharge> parkingCharges = Optional
				.ofNullable(parkingChargeDao.getRepeatParkingCharges(
						parkingCharge.getStart(), 
						parkingCharge.getEnd(), 
						parkingCharge.getCarLicense()))
				.orElse(Collections.emptyList());
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
		}
		return null;
	}
}
