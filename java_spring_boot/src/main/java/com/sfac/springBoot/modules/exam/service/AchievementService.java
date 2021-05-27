package com.sfac.springBoot.modules.exam.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.Achievement;

/**
 * Description: Achievement Service
 * @author HymanHu
 * @date 2021-05-27 12:51:26
 */
public interface AchievementService {

	ResultEntity<Achievement> insertAchievement(Achievement achievement);
	
	ResultEntity<Achievement> updateAchievement(Achievement achievement);
	
	ResultEntity<Object> deleteAchievementById(int id);
	
	Achievement getAchievementById(int id);
	
	PageInfo<Achievement> getAchievementsBySearchBean(SearchBean searchBean);
}
