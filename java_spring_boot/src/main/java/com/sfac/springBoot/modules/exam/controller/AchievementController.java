package com.sfac.springBoot.modules.exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.Achievement;
import com.sfac.springBoot.modules.exam.service.AchievementService;
import com.sfac.springBoot.util.ExcelUtil;

/**
 * Description: Achievement Controller
 * @author HymanHu
 * @date 2021-05-27 14:14:41
 */
@RestController
@RequestMapping("/api")
public class AchievementController {

	@Autowired
	private AchievementService achievementService;
	
	/**
	 * 127.0.0.1/api/achievement ---- post
	 */
	@PostMapping(value = "/achievement", consumes = "application/json")
	public ResultEntity<Achievement> insertAchievement(@RequestBody Achievement achievement) {
		return achievementService.insertAchievement(achievement);
	}
	
	/**
	 * 127.0.0.1/api/achievement ---- put
	 */
	@PutMapping(value = "/achievement", consumes = "application/json")
	public ResultEntity<Achievement> updateAchievement(@RequestBody Achievement achievement) {
		return achievementService.updateAchievement(achievement);
	}
	
	/**
	 * 127.0.0.1/api/achievement/1 ---- delete
	 */
	@DeleteMapping("/achievement/{id}")
	public ResultEntity<Object> deleteAchievementById(@PathVariable int id) {
		return achievementService.deleteAchievementById(id);
	}
	
	/**
	 * 127.0.0.1/api/achievements ---- delete
	 */
	@DeleteMapping("/achievements")
	public ResultEntity<Object> deleteAchievements() {
		return achievementService.deleteAchievements();
	}
	
	/**
	 * 127.0.0.1/api/achievement/1 ---- get
	 */
	@GetMapping("/achievement/{id}")
	public Achievement getAchievementById(@PathVariable int id) {
		return achievementService.getAchievementById(id);
	}
	
	/**
	 * 127.0.0.1/api/achievements ---- post
	 */
	@PostMapping(value = "/achievements", consumes = "application/json")
	public PageInfo<Achievement> getAchievementsBySearchBean(@RequestBody SearchBean searchBean) {
		return achievementService.getAchievementsBySearchBean(searchBean);
	}
	
	/**
	 * 127.0.0.1/api/achievements/excel?keyWord=hj ---- get
	 */
	@GetMapping(value = "/achievements/excel")
	public void exportExcel(@RequestParam String keyWord, 
			HttpServletResponse response) throws IOException {
	    List<Achievement> achievements = achievementService.getAchievementsByKeyWord(keyWord);
	    ExcelUtil.exportExcel(achievements, "考试成绩表", "成绩", Achievement.class, "考试成绩表", response);
	}
	
}
