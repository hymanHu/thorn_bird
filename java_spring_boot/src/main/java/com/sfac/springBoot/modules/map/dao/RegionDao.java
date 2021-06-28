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
	
	@Select("select * from map_Region where city_code = #{keyWord} or ad_code = #{adCode} or name = #{name}")
	Region getRegionByKeyWord(String keyWord);
}
