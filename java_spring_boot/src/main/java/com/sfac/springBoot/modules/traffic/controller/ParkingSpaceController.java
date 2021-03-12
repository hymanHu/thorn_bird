package com.sfac.springBoot.modules.traffic.controller;

import java.util.List;

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
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace;
import com.sfac.springBoot.modules.traffic.service.ParkingSpaceService;

/**
 * Description: Parking Space Controller
 * @author HymanHu
 * @date 2021-03-12 15:34:58
 */
@RestController
@RequestMapping("/api")
public class ParkingSpaceController {
	
	@Autowired
	private ParkingSpaceService parkingSpaceService;
	
	/**
	 * 127.0.0.1/api/parkingSpace ---- post
	 * {"parkingSpaceType":"standard", "status":0}
	 */
	@PostMapping(value = "/parkingSpace", consumes = "application/json")
	public ResultEntity<ParkingSpace> insertParkingSpace(@RequestBody ParkingSpace parkingSpace) {
		return parkingSpaceService.insertParkingSpace(parkingSpace);
	}
	
	/**
	 * 127.0.0.1/api/parkingSpace ---- put
	 * {"id":1, "parkingSpaceType":"standard", "status":0}
	 */
	@PutMapping(value = "/parkingSpace", consumes = "application/json")
	public ResultEntity<ParkingSpace> updateParkingSpace(@RequestBody ParkingSpace parkingSpace) {
		return parkingSpaceService.updateParkingSpace(parkingSpace);
	}
	
	/**
	 * 127.0.0.1/api/parkingSpace/101 ---- delete
	 */
	@DeleteMapping("/parkingSpace/{id}")
	public ResultEntity<Object> deleteParkingSpaceById(@PathVariable int id) {
		return parkingSpaceService.deleteParkingSpaceById(id);
	}
	
	/**
	 * 127.0.0.1/api/parkingSpace/1 ---- get
	 */
	@GetMapping("/parkingSpace/{id}")
	public ParkingSpace getParkingSpaceById(@PathVariable int id) {
		return parkingSpaceService.getParkingSpaceById(id);
	}
	
	/**
	 * 127.0.0.1/api/parkingSpaces/1 ---- get
	 */
	@GetMapping("/parkingSpaces/{status}")
	public List<ParkingSpace> getParkingSpacesByStatus(@PathVariable int status) {
		return parkingSpaceService.getParkingSpacesByStatus(status);
	}
	
	/**
	 * 127.0.0.1/api/parkingSpaces ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/parkingSpaces", consumes = "application/json")
	public PageInfo<ParkingSpace> getParkingSpacesBySearchBean(@RequestBody SearchBean searchBean) {
		return parkingSpaceService.getParkingSpacesBySearchBean(searchBean);
	}

}
