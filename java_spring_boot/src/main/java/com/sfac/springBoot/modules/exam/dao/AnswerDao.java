package com.sfac.springBoot.modules.exam.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.exam.entity.Answer;
import com.sfac.springBoot.modules.exam.entity.Question;

/**
 * Description: Answer Dao
 * @author HymanHu
 * @date 2021-05-26 10:39:10
 */
@Mapper
@Repository
public interface AnswerDao {
	
	@Insert("insert into exam_answer (achievement_id, question_id, user_answer) "
			+ "values (#{achievementId}, #{questionId}, #{userAnswer})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertAnswer(Answer answer);
	
	@Update("update exam_answer set achievement_id = #{achievementId}, question_id = #{questionId}, "
			+ "user_answer = #{userAnswer} where id = #{id}")
	void updateAnswer(Answer answer);
	
	@Delete("delete from exam_answer where achievement_id = #{achievementId}")
	void deleteAnswersByAchievementId(int achievementId);
	
	@Select("select * from exam_answer where id = #{id}")
	@Results(id="answerResult", value={
			@Result(column="question_id", property="questionId"),
			@Result(column="question_id",property="question",
				javaType=Question.class,
				one=@One(select="com.sfac.springBoot.modules.exam.dao.QuestionDao.getQuestionById"))
		})
	Answer getAnswerById(int id);
	
	@Select("select * from exam_answer where achievement_id = #{achievementId}")
	@ResultMap(value = "answerResult")
	List<Answer> getAnswersByAchievementId(int achievementId);

}
