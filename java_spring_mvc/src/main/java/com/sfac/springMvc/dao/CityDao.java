package com.sfac.springMvc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.entity.City;

/**
 * Description: City Dao
 * @author HymanHu
 * @date 2020-12-09 16:25:13
 */
@Repository
@Mapper
public interface CityDao {
	
	@Insert("insert into city (city_id, city_name, local_city_name, country_id, district, population, "
			+ "date_modified, date_created) values (#{cityId}, #{cityName}, #{localCityName}, "
			+ "#{countryId}, #{district}, #{population}, #{dateModified}, #{dateCreated})")
	@Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityId")
	void insertCity(City city);
	
	@Update("update city set city_name = #{cityName}, local_city_name = #{localCityName}, "
			+ "country_id = #{countryId}, district = #{district}, population = #{population}, "
			+ "date_modified = #{dateModified}, date_created = #{dateCreated} "
			+ "where city_id = #{cityId}")
	void updateCity(City city);
}
