package com.sfac.springBoot.modules.traffic.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge;

/**
 * Description: Parking Charge Service
 * @author HymanHu
 * @date 2021-03-22 16:37:43
 */
public interface ParkingChargeService {

	ResultEntity<ParkingCharge> insertParkingCharge(ParkingCharge parkingCharge);
	
	ResultEntity<ParkingCharge> updateParkingCharge(ParkingCharge parkingCharge);
	
	ResultEntity<Object> deleteParkingCharge(int id);
	
	ParkingCharge getParkingChargeById(int id);
	
	PageInfo<ParkingCharge> getParkingChargesBySearchBean(SearchBean searchBean);
}
