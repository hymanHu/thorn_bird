package com.sfac.springMvc.module.humanNature.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.humanNature.entity.Track;
import com.sfac.springMvc.module.humanNature.entity.TrackTypeVo;

/**
 * @Description: Track Service
 * @author: HymanHu
 * @date: 2021年2月8日
 */
public interface TrackService {

	ResultEntity<Track> insertTrack(Track track);
	
	ResultEntity<Track> updateTrack(Track track);
	
	ResultEntity<Object> deleteTrack(int id);
	
	Track getTrackById(int id);
	
	PageInfo<Track> getTracksBySearchBean(SearchBean searchBean);
	
	List<TrackTypeVo> getTrackTypeCountByTarget(String target);
	
	Map<String, List<TrackTypeVo>> getTrackTypeStatisticsByTargetAndType(String target, String type);
}
