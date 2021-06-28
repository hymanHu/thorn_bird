package com.sfac.springBoot.modules.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springBoot.modules.map.entity.Region;
import com.sfac.springBoot.modules.map.service.RegionService;

/**
 * Description: Region Controller
 * @author HymanHu
 * @date 2021-06-28 09:43:52
 */
@RestController
@RequestMapping("/api")
public class RegionController {
	
	@Autowired
	private RegionService regionService;

	/**
	 * http://127.0.0.1/api/region/init ---- get
	 */
	@GetMapping("/region/init")
	public List<Region> initRegionByAmap() {
		return regionService.initRegionByAmap();
	}
	
	/**
	 * http://127.0.0.1/api/region?keyWord=440000&subdistric=4 ---- get
	 * @param keyWord		搜索关键词：行政区名称、cityCode、adcode
	 * @param subdistric	设置显示下级行政区级数: 0 ~ 4
	 * @return Region
	 */
	@GetMapping("/region")
	public Region getRegionByKeyWord(String keyWord, int subdistric) {
		Region currentRegion = regionService.getRegionByKeyWord(keyWord, subdistric);
		return currentRegion;
	}
}
