package com.sfac.springBoot.modules.exam.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Description: Paper Question Dao
 * @author HymanHu
 * @date 2021-05-26 09:58:42
 */
@Mapper
@Repository
public interface PaperQuestionDao {
	
	@Insert("insert into exam_paper_question (paper_id, question_id) values (#{paperId}, #{questionId})")
	void insertPaperQuestion(@Param("paperId") int paperId, @Param("questionId") int questionId);
	
	@Delete("delete from exam_paper_question where paper_id = #{paperId}")
	void deletePaperQuestionsByPaperId(int paperId);
	
	@Delete("delete from exam_paper_question")
	void deletePaperQuestions();

}
