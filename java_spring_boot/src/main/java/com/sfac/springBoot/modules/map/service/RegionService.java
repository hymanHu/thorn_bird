package com.sfac.springBoot.modules.map.service;

import java.util.List;

import com.sfac.springBoot.modules.map.entity.Region;

/**
 * Description: Region Service
 * @author HymanHu
 * @date 2021-06-28 09:03:06
 */
public interface RegionService {

	// 根据高德地图 Api 初始化行政区域
	List<Region> initRegionByAmap();
	
	Region getRegionByKeyWord(String keyWord, int subdistric);
	
}
