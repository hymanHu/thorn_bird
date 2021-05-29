package com.sfac.springBoot.modules.exam.controller;

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
import com.sfac.springBoot.modules.exam.entity.Paper;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;
import com.sfac.springBoot.modules.exam.service.PaperService;

/**
 * Description: Pager Controller
 * @author HymanHu
 * @date 2021-05-26 10:16:28
 */
@RestController
@RequestMapping("/api")
public class PagerController {

	@Autowired
	private PaperService paperService;
	
	/**
	 * 127.0.0.1/api/apper ---- post
	 * {"paperTitle":"test1","paperFlage":"java","paperTypes":["singleChoice","multipleChoice"],"paperTime":45}
	 */
	@PostMapping(value = "/paper", consumes = "application/json")
	public ResultEntity<Paper> insertPaper(@RequestBody PaperBuilder paperBuilder) {
		return paperService.insertPaper(paperBuilder);
	}
	
	/**
	 * 127.0.0.1/api/paper ---- put
	 * {"id":1,"subject":"test11","totalTime":45,"totalScore":100}
	 */
	@PutMapping(value = "/paper", consumes = "application/json")
	public ResultEntity<Paper> updatePaper(@RequestBody Paper paper) {
		return paperService.updatePaper(paper);
	}
	
	/**
	 * 127.0.0.1/api/paper/1 ---- delete
	 */
	@DeleteMapping("/paper/{id}")
	public ResultEntity<Object> deletePaperById(@PathVariable int id) {
		return paperService.deletePaperById(id);
	}
	
	/**
	 * 127.0.0.1/api/papers ---- delete
	 */
	@DeleteMapping("/papers")
	public ResultEntity<Object> deletePapers() {
		return paperService.deletePapers();
	}
	
	/**
	 * 127.0.0.1/api/paper/1 ---- get
	 */
	@GetMapping("/paper/{id}")
	public Paper getPaperById(@PathVariable int id) {
		return paperService.getPaperById(id);
	}
	
	/**
	 * 127.0.0.1/api/papers ---- post
	 * {"currentPage":"1","pageSize":"5","orderBy":"id","direction":"desc","keyWord":""}
	 */
	@PostMapping(value = "/papers", consumes = "application/json")
	public PageInfo<Paper> getPagersBySearchBean(@RequestBody SearchBean searchBean) {
		return paperService.getPagersBySearchBean(searchBean);
	}
}
