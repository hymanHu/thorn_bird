package com.sfac.springBoot.modules.map.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.map.entity.Region;

/**
 * Description: Region Dao
 * @author HymanHu
 * @date 2021-06-28 14:16:31
 */
@Mapper
@Repository
public interface RegionDao {
	
	@Insert("insert into map_Region (city_code, ad_code, name, center, level, area, perimeter, create_date) values "
			+ "(#{cityCode}, #{adCode}, #{name}, #{center}, #{level}, #{area}, #{perimeter}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertRegion(Region region);
	
	@Insert("<script>"
			+ "insert into map_Region (city_code, ad_code, name, center, level, "
			+ "area, perimeter, create_date) values "
			+ "<foreach collection='regions' item='region' index='index' separator=','>"
			+ "(#{region.cityCode}, #{region.adCode}, #{region.name}, #{region.center}, "
			+ "#{region.level}, #{region.area}, #{region.perimeter}, #{region.createDate})"
			+ "</foreach>"
			+ "</script>")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void batchInsertRegions(@Param("regions") List<Region> regions);
	
	@Delete("delete from map_Region")
	void deleteAllRegion();
	
	@Select("<script>"
			+ "select * from map_Region "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (city_code = #{keyWord} or ad_code = #{adCode} or name = #{name}) "
			+ "</if>"
			+ "<if test='keyWord == \"\"'>"
			+ " and (ad_code = '100000') "
			+ "</if>"
			+ "</where>"
			+ " limit 1"
			+ "</script>")
	Region getRegionByKeyWord(String keyWord);
	
	@Select("<script>"
			+ "select * from map_Region "
			+ "<where> "
			+ "<if test='parentCode != \"\" and parentCode != null'>"
			+ " and (ad_code like '${parentCode}%') "
			+ "</if>"
			+ " and level = #{level} "
			+ "</where>"
			+ " order by ad_code asc"
			+ "</script>")
	List<Region> getRegionsByParentCodeAndLevel(String parentCode, String level);
}
