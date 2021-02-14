package com.sfac.springMvc.module.humanNature.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.humanNature.entity.Track;
import com.sfac.springMvc.module.humanNature.entity.TrackTypeVo;

/**
 * @Description: Track Dao
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@Mapper
@Repository
public interface TrackDao {
	
	@Insert("insert into hn_track (target, description, type, assessment, date_time, create_date) "
			+ "values (#{target}, #{description}, #{type}, #{assessment}, #{dateTime}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertTrack(Track track);
	
	@Update("update hn_track set target = #{target}, description = #{description}, type = #{type}, "
			+ "assessment = #{assessment}, date_time = #{dateTime} where id = #{id}")
	void updateTrack(Track track);
	
	@Delete("delete from hn_track where id = #{id}")
	void deleteTrack(int id);
	
	@Select("select * from hn_track where id = #{id}")
	Track getTrackById(int id);
	
	@Select("<script>"
			+ "select * from hn_track "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (target like '%${keyWord}%' or "
			+ " description like '%${keyWord}%') "
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
	List<Track> getTracksBySearchBean(SearchBean searchBean);
	
	@Select("<script>"
			+ "select type, count(id) as count, sum(assessment) as assessment from hn_track "
			+ "<where> "
			+ "<if test='target != \"\" and target != null'>"
			+ " and target = #{target} "
			+ "</if>"
			+ "</where>"
			+ " group by type order by count desc"
			+ "</script>")
	List<TrackTypeVo> getTrackTypeCountByTarget(@Param("target") String target);

	@Select("<script>"
			+ "select type, count(id) as count, date_format( date_time, '%Y-%m' ) as yearMounth from hn_track "
			+ "<where> "
			+ "<if test='target != \"\" and target != null'>"
			+ " and target = #{target} "
			+ "</if>"
			+ "<if test='type != \"\" and type != null'>"
			+ " and type = #{type} "
			+ "</if>"
			+ "</where>"
			+ " group by type, date_format( date_time, '%Y-%m' ) order by type, yearMounth desc"
			+ "</script>")
	List<TrackTypeVo> getTrackTypeStatisticsByTargetAndType(
			@Param("target") String target, @Param("type") String type);
}
