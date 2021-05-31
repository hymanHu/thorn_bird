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
import com.sfac.springBoot.modules.exam.entity.Achievement;

/**
 * Description: Achievement Dao
 * @author HymanHu
 * @date 2021-05-27 10:59:42
 */
@Mapper
@Repository
public interface AchievementDao {
	
	@Insert("insert into exam_achievement (user_id, subject, total_score, reference_score, score, "
			+ "percent_score, total_time, spend_time, exam_date, create_date) "
			+ "values (#{userId}, #{subject}, #{totalScore}, #{referenceScore}, #{score}, "
			+ "#{percentScore}, #{totalTime}, #{spendTime}, #{examDate}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertAchievement(Achievement achievement);
	
	@Update("update exam_achievement set score = #{score}, reference_score = #{referenceScore}, "
			+ "percent_score = #{percentScore} where id = #{id}")
	void updateAchievement(Achievement achievement);
	
	@Delete("delete from exam_achievement where id = #{id}")
	void deleteAchievementById(int id);
	
	@Delete("delete from exam_achievement")
	void deleteAchievements();
	
	@Select("select * from exam_achievement a left join account_user u on a.user_id = u.id where a.id = #{id}")
	@Results(id="achievementResult", value={
			@Result(column="id", property="id"),
			@Result(column="id",property="answers",
				javaType=List.class,
				many=@Many(select="com.sfac.springBoot.modules.exam.dao.AnswerDao.getAnswersByAchievementId"))
		})
	Achievement getAchievementById(int id);
	
	@Select("<script>"
			+ "select *, ifnull(au.user_name, '游客') as userName from exam_achievement ea "
			+ "left join account_user au on ea.user_id = au.id "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (ea.subject like '%${keyWord}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ " order by ${orderBy} ${direction}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by ea.id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<Achievement> getAchievementsBySearchBean(SearchBean searchBean);

}
