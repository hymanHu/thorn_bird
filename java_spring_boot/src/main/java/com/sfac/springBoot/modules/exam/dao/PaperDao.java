package com.sfac.springBoot.modules.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.Paper;

/**
 * Description: Paper Dao
 * @author HymanHu
 * @date 2021-05-26 09:29:23
 */
@Mapper
@Repository
public interface PaperDao {
	
	@Insert("insert into exam_paper (subject, total_time, total_score, create_date) "
			+ "value (#{subject}, #{totalTime}, #{totalScore}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertPaper(Paper paper);
	
	@Update("update exam_paper set subject = #{subject}, total_time = #{totalTime}, "
			+ "total_score = #{totalScore} where id = #{id}")
	void updatePaper(Paper paper);
	
	@Delete("delete from exam_paper where id = #{id}")
	void deletePaperById(int id);
	
	@Delete("delete from exam_paper")
	void deletePapers();
	
	@Select("select * from exam_paper where id = #{id}")
	@Results(id="paperResult", value={
			@Result(column="id", property="id"),
			@Result(column="id",property="questions",
				javaType=List.class,
				many=@Many(select="com.sfac.springBoot.modules.exam.dao.QuestionDao.getQuestionsByPaperId"))
		})
	Paper getPaperById(int id);
	
	
	@Select("<script>"
			+ "select * from exam_paper "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (subject like '%${keyWord}%') "
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
	List<Paper> getPagersBySearchBean(SearchBean searchBean);

}
