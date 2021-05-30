package com.sfac.springBoot.modules.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;
import com.sfac.springBoot.modules.exam.entity.Question;

/**
 * Description: Question Dao
 * @author HymanHu
 * @date 2021-05-25 15:57:33
 */
@Mapper
@Repository
public interface QuestionDao {
	
	@Insert("insert into exam_question (type, flag, content, image, score, option_a, option_b, option_c, "
			+ "option_d, reference_answer, comment, create_date) "
			+ "values (#{type}, #{flag}, #{content}, #{image}, #{score}, #{optionA}, #{optionB}, "
			+ "#{optionC}, #{optionD}, #{referenceAnswer}, #{comment}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertQuestion(Question question);
	
	@Update("update exam_question set type = #{type}, flag = #{flag}, content = #{content}, image = #{image}, "
			+ "score = #{score}, option_a = #{optionA}, option_b = #{optionB}, option_c = #{optionC}, "
			+ "option_d = #{optionD}, reference_answer = #{referenceAnswer}, comment = #{comment} where id = #{id}")
	void updateQuestion(Question question);
	
	@Delete("delete from exam_question where id = #{id}")
	void deleteQuestion(int id);
	
	@Select("select * from exam_question where id = #{id}")
	Question getQuestionById(int id);
	
	@Select("<script>"
			+ "select * from exam_question "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (content like '%${keyWord}%' or "
			+ " comment like '%${keyWord}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ " order by ${orderBy} ${direction}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<Question> getQuestionsBySearchBean(SearchBean searchBean);
	
	@Select("select * from exam_question q left join exam_paper_question pq "
			+ "on q.id = pq.question_id where pq.paper_id = #{paperId} order by type")
	List<Question> getQuestionsByPaperId(int paperId);
	
	@Select("<script>"
			+ "select * from exam_question"
			+ "<where> "
			+ " and (flag = #{paperFlage})"
			+ "<if test='paperTypesString != \"\" and paperTypesString != null'>"
			+ " and (type in (${paperTypesString})) "
			+ "</if>"
			+ "</where>"
			+ "order by type"
			+ "</script>")
	List<Question> getQuestionsByPaperBuilder(PaperBuilder paperBuilder);
}
