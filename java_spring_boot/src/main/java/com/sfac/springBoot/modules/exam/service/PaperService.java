package com.sfac.springBoot.modules.exam.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.Paper;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;

/**
 * Description: 
 * @author HymanHu
 * @date 2021-05-26 09:43:03
 */
public interface PaperService {
	
	ResultEntity<Paper> insertPaper(PaperBuilder paperBuilder);
	
	ResultEntity<Paper> updatePaper(Paper paper);
	
	ResultEntity<Object> deletePaperById(int id);
	
	Paper getPaperById(int id);
	
	PageInfo<Paper> getPagersBySearchBean(SearchBean searchBean);

}
