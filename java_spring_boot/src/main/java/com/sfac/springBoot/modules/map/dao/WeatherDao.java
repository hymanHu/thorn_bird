package com.sfac.springBoot.modules.map.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.map.entity.Weather;

/**
 * Description: Weather Dao
 * @author HymanHu
 * @date 2021-06-29 10:03:49
 */
@Mapper
@Repository
public interface WeatherDao {
	
	@Insert("insert into map_weather (province, city, ad_code, meteorology, temperature, "
			+ "wind_direction, wind_power, humidity, report_time, create_date) "
			+ "values (#{province}, #{city}, #{adCode}, #{meteorology}, #{temperature}, #{windDirection}, "
			+ "#{windPower}, #{humidity}, #{reportTime}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertWeather(Weather weather);
	
	@Select("select * from map_weather where ad_code = #{adCode} and report_time = #{reportTime}")
	Weather getWeatherByAdCodeAndReportTime(@Param("adCode") String adCode, @Param("reportTime") LocalDateTime reportTime);
	
	@Select("select * from map_weather where ad_code = #{adCode} and TIMESTAMPDIFF(MINUTE, report_time, now()) < ${minutes}")
	List<Weather> getWeathersByAdCodeAndMinutes(@Param("adCode") String adCode, @Param("minutes") int minutes);
	
	@Select("select * from map_weather where ad_code = #{adCode} order by report_time desc")
	List<Weather> getWeathersByAdCode(@Param("adCode") String adCode);

}
