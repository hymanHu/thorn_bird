package com.sfac.springBoot.modules.traffic.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace;

/**
 * Description: Parking Space Service
 * @author HymanHu
 * @date 2021-03-12 15:16:49
 */
public interface ParkingSpaceService {

	ResultEntity<ParkingSpace> insertParkingSpace(ParkingSpace parkingSpace);
	
	ResultEntity<ParkingSpace> updateParkingSpace(ParkingSpace parkingSpace);
	
	ResultEntity<Object> deleteParkingSpaceById(int id);
	
	ParkingSpace getParkingSpaceById(int id);
	
	List<ParkingSpace> getParkingSpacesByStatus(int status);
	
	PageInfo<ParkingSpace> getParkingSpacesBySearchBean(SearchBean searchBean);
}
