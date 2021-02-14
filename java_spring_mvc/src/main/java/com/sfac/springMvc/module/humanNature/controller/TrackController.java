package com.sfac.springMvc.module.humanNature.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.humanNature.entity.Track;
import com.sfac.springMvc.module.humanNature.entity.TrackTypeVo;
import com.sfac.springMvc.module.humanNature.service.TrackService;

/**
 * @Description: Track Controller
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@RestController
@RequestMapping("/api")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	/**
	 * 127.0.0.1/api/track ---- post
	 * {"target":"胡江","description":"回家过年","type":"家庭","assessment":"1","dateTime":"2021-02-08 13:13:13"}
	 */
	@PostMapping(value = "/track", consumes = "application/json")
	public ResultEntity<Track> insertTrack(@RequestBody Track track) {
		return trackService.insertTrack(track);
	}
	
	/**
	 * 127.0.0.1/api/track ---- put
	 * {"id":1,"target":"胡江1","description":"回家过年1","type":"家庭","assessment":"11",
	 * "dateTime":"2021-02-08 14:14:14"}
	 */
	@PutMapping(value = "/track", consumes = "application/json")
	public ResultEntity<Track> updateTrack(@RequestBody Track track) {
		return trackService.updateTrack(track);
	}
	
	/**
	 * 127.0.0.1/api/track/2 ---- delete
	 */
	@DeleteMapping("/track/{id}")
	public ResultEntity<Object> deleteTrack(@PathVariable int id) {
		return trackService.deleteTrack(id);
	}
	
	/**
	 * 127.0.0.1/api/track/1 ---- get
	 */
	@GetMapping("/track/{id}")
	public Track getTrackById(@PathVariable int id) {
		return trackService.getTrackById(id);
	}
	
	/**
	 * 127.0.0.1/api/tracks ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/tracks", consumes = "application/json")
	public PageInfo<Track> getTracksBySearchBean(@RequestBody SearchBean searchBean) {
		return trackService.getTracksBySearchBean(searchBean);
	}
	
	/**
	 * -统计各种类型总次数、百分比、估值等信息
	 * 127.0.0.1/api/trackTypeVos/count?target=翠花 ---- get
	 */
	@GetMapping("/trackTypeVos/count")
	public List<TrackTypeVo> getTrackTypeCountByTarget(
			@RequestParam(name = "target", required = false) String target) {
		return trackService.getTrackTypeCountByTarget(target);
	}
	
	/**
	 * -统计各种类型每月发生次数
	 * 127.0.0.1/api/trackTypeVos/statistics?target=翠花&type=工作 ---- get
	 */
	@GetMapping("/trackTypeVos/statistics")
	public Map<String, List<TrackTypeVo>> getTrackTypeStatisticsByTargetAndType(
			@RequestParam(name = "target", required = false) String target, 
			@RequestParam(name = "type", required = false) String type) {
		return trackService.getTrackTypeStatisticsByTargetAndType(target, type);
	}

}
