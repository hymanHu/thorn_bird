package com.sfac.springBoot.modules.traffic.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.ResultEntity.ResultStatus;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.dao.ParkingSpaceDao;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace;
import com.sfac.springBoot.modules.traffic.service.ParkingSpaceService;

/**
 * Description: Parking Space Service Impl
 * @author HymanHu
 * @date 2021-03-12 15:17:24
 */
@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
	
	@Autowired
	private ParkingSpaceDao parkingSpaceDao;

	@Override
	@Transactional
	public ResultEntity<ParkingSpace> insertParkingSpace(ParkingSpace parkingSpace) {
		parkingSpace.setCreateDate(LocalDateTime.now());
		parkingSpaceDao.insertParkingSpace(parkingSpace);
		return new ResultEntity<ParkingSpace>(ResultStatus.SUCCESS.status, "Insert success.", parkingSpace);
	}

	@Override
	@Transactional
	public ResultEntity<ParkingSpace> updateParkingSpace(ParkingSpace parkingSpace) {
		parkingSpaceDao.updateParkingSpace(parkingSpace);
		return new ResultEntity<ParkingSpace>(ResultStatus.SUCCESS.status, "Update success.", parkingSpace);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteParkingSpaceById(int id) {
		parkingSpaceDao.deleteParkingSpaceById(id);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public ParkingSpace getParkingSpaceById(int id) {
		return parkingSpaceDao.getParkingSpaceById(id);
	}

	@Override
	public List<ParkingSpace> getParkingSpacesByStatus(int status) {
		return Optional.ofNullable(parkingSpaceDao.getParkingSpacesByStatus(status))
				.orElse(Collections.emptyList());
	}

	@Override
	public PageInfo<ParkingSpace> getParkingSpacesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<ParkingSpace>(
				Optional.ofNullable(parkingSpaceDao.getParkingSpacesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}
	
}
