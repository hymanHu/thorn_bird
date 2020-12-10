package com.sfac.springMvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
			+ "date_modified = #{dateModified} where city_id = #{cityId}")
	void updateCity(City city);
	
	@Delete("delete from city where city_id = #{cityId}")
	void deleteCityByCityId(int cityId);
	
	@Select("select ci.*, co.country_name from city ci "
			+ "left join country co on ci.country_id = co.country_id "
			+ "where ci.city_id = #{cityId}")
	City getCityByCityId(int cityId);
	
	@Select("select * from city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);
}
