package com.sfac.springBoot.modules.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge;
import com.sfac.springBoot.modules.traffic.service.ParkingChargeService;

/**
 * Description: Parking Charge Controller
 * @author HymanHu
 * @date 2021-03-22 16:48:00
 */
@RestController
@RequestMapping("/api")
public class ParkingChargeController {
	
	@Autowired
	private ParkingChargeService parkingChargeService;
	
	/**
	 * 127.0.0.1/api/parkingCharge ---- post
	 * {"carLicense":"川A44444","chargeType":0,"parkingId":0,"start":"2021-03-22 16:48:00","sum":0,"fee":0.0}
	 */
	@PostMapping(value = "/parkingCharge", consumes = "application/json")
	public ResultEntity<ParkingCharge> insertParkingCharge(@RequestBody ParkingCharge parkingCharge) {
		return parkingChargeService.insertParkingCharge(parkingCharge);
	}
	
	/**
	 * 127.0.0.1/api/parkingCharge ---- put
	 * {"id":1,"carLicense":"川A44444","chargeType":0,"parkingId":0,"start":"2021-03-22 16:48:00","sum":0,"fee":0.0}
	 */
	@PutMapping(value = "/parkingCharge", consumes = "application/json")
	public ResultEntity<ParkingCharge> updateParkingCharge(@RequestBody ParkingCharge parkingCharge) {
		return parkingChargeService.updateParkingCharge(parkingCharge);
	}
	
	/**
	 * 127.0.0.1/api/parkingCharge/10 ---- delete
	 */
	@DeleteMapping("/parkingCharge/{id}")
	public ResultEntity<Object> deleteParkingCharge(@PathVariable int id) {
		return parkingChargeService.deleteParkingCharge(id);
	}
	
	/**
	 * 127.0.0.1/api/parkingCharge/1 ---- get
	 */
	@GetMapping("/parkingCharge/{id}")
	public ParkingCharge getParkingChargeById(@PathVariable int id) {
		return parkingChargeService.getParkingChargeById(id);
	}
	
	/**
	 * 127.0.0.1/api/parkingCharges ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/parkingCharges", consumes = "application/json")
	public PageInfo<ParkingCharge> getParkingChargesBySearchBean(@RequestBody SearchBean searchBean) {
		return parkingChargeService.getParkingChargesBySearchBean(searchBean);
	}
	
	/**
	 * 127.0.0.1/api/parkingCharge/fee ---- post
	 * {"carLicense":"川A44444","chargeType":1,"parkingId":0,"start":"2021-04-01 00:00:00",
	 * "end":"2021-04-07 23:59:59","sum":0,"fee":0.0}
	 */
	@PostMapping(value = "/parkingCharge/fee", consumes = "application/json")
	public ResultEntity<ParkingCharge> calculateParkingCharge(@RequestBody ParkingCharge parkingCharge) {
		return parkingChargeService.calculateParkingCharge(parkingCharge);
	}
}
