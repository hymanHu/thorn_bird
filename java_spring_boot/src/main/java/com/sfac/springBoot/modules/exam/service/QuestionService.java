package com.sfac.springBoot.modules.exam.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;
import com.sfac.springBoot.modules.exam.entity.Question;

/**
 * Description: Question Service
 * @author HymanHu
 * @date 2021-05-25 16:27:08
 */
public interface QuestionService {
	
	ResultEntity<Question> insertQuestion(Question question);
	
	ResultEntity<Question> updateQuestion(Question question);
	
	ResultEntity<Object> deleteQuestion(int id);
	
	Question getQuestionById(int id);
	
	PageInfo<Question> getQuestionsBySearchBean(SearchBean searchBean);
	
	List<Question> getQuestionsByPaperId(int paperId);
	
	List<Question> getQuestionsByPaperBuilder(PaperBuilder paperBuilder);
}
