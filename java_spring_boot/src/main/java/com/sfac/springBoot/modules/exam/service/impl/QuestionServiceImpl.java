package com.sfac.springBoot.modules.exam.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.dao.QuestionDao;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;
import com.sfac.springBoot.modules.exam.entity.Question;
import com.sfac.springBoot.modules.exam.service.QuestionService;

/**
 * Description: Question Service Impl
 * @author HymanHu
 * @date 2021-05-26 09:29:12
 */
@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	@Transactional
	public ResultEntity<Question> insertQuestion(Question question) {
		question.setCreateDate(LocalDateTime.now());
		questionDao.insertQuestion(question);
		return new ResultEntity<Question>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success.", question);
	}

	@Override
	@Transactional
	public ResultEntity<Question> updateQuestion(Question question) {
		questionDao.updateQuestion(question);
		return new ResultEntity<Question>(ResultEntity.ResultStatus.SUCCESS.status, "Update success.", question);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteQuestion(int id) {
		questionDao.deleteQuestion(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Question getQuestionById(int id) {
		return questionDao.getQuestionById(id);
	}

	@Override
	public PageInfo<Question> getQuestionsBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Question>(
				Optional.ofNullable(questionDao.getQuestionsBySearchBean(searchBean))
					.orElse(Collections.emptyList()));
	}

	@Override
	public List<Question> getQuestionsByPaperId(int paperId) {
		return questionDao.getQuestionsByPaperId(paperId);
	}

	@Override
	public List<Question> getQuestionsByPaperBuilder(PaperBuilder paperBuilder) {
		paperBuilder.initPaperTypesString();
		return questionDao.getQuestionsByPaperBuilder(paperBuilder);
	}

}
