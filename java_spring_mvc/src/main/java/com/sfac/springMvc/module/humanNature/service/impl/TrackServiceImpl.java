package com.sfac.springMvc.module.humanNature.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.humanNature.dao.TrackDao;
import com.sfac.springMvc.module.humanNature.entity.Track;
import com.sfac.springMvc.module.humanNature.entity.TrackType;
import com.sfac.springMvc.module.humanNature.entity.TrackTypeVo;
import com.sfac.springMvc.module.humanNature.service.TrackService;

/**
 * @Description: Track Service Impl
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@Service
public class TrackServiceImpl implements TrackService {
	
	@Autowired
	private TrackDao trackDao;

	@Override
	@Transactional
	public ResultEntity<Track> insertTrack(Track track) {
		track.setCreateDate(LocalDateTime.now());
		trackDao.insertTrack(track);
		return new ResultEntity<Track>(ResultEntity.ResultStatus.SUCCESS.status, "Success insert track", track);
	}

	@Override
	@Transactional
	public ResultEntity<Track> updateTrack(Track track) {
		trackDao.updateTrack(track);
		return new ResultEntity<Track>(ResultEntity.ResultStatus.SUCCESS.status, "Update insert track", track);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteTrack(int id) {
		trackDao.deleteTrack(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete insert track");
	}

	@Override
	public Track getTrackById(int id) {
		return trackDao.getTrackById(id);
	}

	@Override
	public PageInfo<Track> getTracksBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Track>(Optional
				.ofNullable(trackDao.getTracksBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

	@Override
	public List<TrackTypeVo> getTrackTypeCountByTarget(String target) {
		List<TrackTypeVo> trackTypeVos = Optional
				.ofNullable(trackDao.getTrackTypeCountByTarget(target))
				.orElse(Collections.emptyList());
		if (trackTypeVos.isEmpty()) {
			return trackTypeVos;
		}
		
		int total = trackTypeVos.stream().map(item -> item.getCount()).reduce((i, j) -> i + j).get();
		return trackTypeVos.stream()
			.map(item -> {
				BigDecimal bd = new BigDecimal(((double)item.getCount() / (double)total) * 100);
				item.setPercent(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				
				TrackType trackType = TrackType.getTrackTypeByName(item.getType());
				if (item.getAssessment() >= 0) {
					item.setLabel(trackType.labelA);
				} else {
					item.setLabel(trackType.labelB);
				}
				return item;
				})
			.collect(Collectors.toList());
	}

	@Override
	public Map<String, List<TrackTypeVo>> getTrackTypeStatisticsByTargetAndType(String target, String type) {
		List<TrackTypeVo> trackTypeVos = Optional
				.ofNullable(trackDao.getTrackTypeStatisticsByTargetAndType(target, type))
				.orElse(Collections.emptyList());
		// 按照 type 分组，并转为 map
		Map<String, List<TrackTypeVo>> map = trackTypeVos.stream()
				.collect(Collectors.groupingBy(TrackTypeVo :: getType));
		// 根据 map value 进行排序，集合元素越多的放在前面
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size()))
				.collect(Collectors.toMap(
						Map.Entry :: getKey,
						Map.Entry :: getValue,
						(oldValue, newValue) -> oldValue,
						LinkedHashMap :: new));
	}
}
