package com.sfac.springBoot.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.test.entity.City;

/**
 * Description: City Dao
 * @author HymanHu
 * @date 2020-12-09 16:25:13
 */
@Repository
@Mapper
public interface CityDao {
	
	/**
	 * 配置文件方式
	 * application.properties
	 * mybatis.type-aliases-package=com.hqyj.demo.modules.*.entity
	 * mybatis.mapper-locations=classpath:mapper/*Mapper.xml
	 * 读取cityMapper.xml，方法名和mapper中设置的id一致
	 */
	List<City> getCitiesByCountryId(int countryId);
	
	@Insert("insert into test_city (city_id, city_name, local_city_name, country_id, district, population, "
			+ "date_modified, date_created) values (#{cityId}, #{cityName}, #{localCityName}, "
			+ "#{countryId}, #{district}, #{population}, #{dateModified}, #{dateCreated})")
	@Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityId")
	void insertCity(City city);
	
	@Update("update test_city set city_name = #{cityName}, local_city_name = #{localCityName}, "
			+ "country_id = #{countryId}, district = #{district}, population = #{population}, "
			+ "date_modified = #{dateModified} where city_id = #{cityId}")
	void updateCity(City city);
	
	@Delete("delete from test_city where city_id = #{cityId}")
	void deleteCityByCityId(int cityId);
	
	@Select("select ci.*, co.country_name from test_city ci "
			+ "left join test_country co on ci.country_id = co.country_id "
			+ "where ci.city_id = #{cityId}")
	City getCityByCityId(int cityId);
	
	@Select("select * from test_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId2(int countryId);
	
	@Select("<script>"
		+ "select ci.*, co.country_name from test_city ci left join test_country co "
		+ "on ci.country_id = co.country_id "
		+ "<where> "
		+ "<if test='keyWord != \"\" and keyWord != null'>"
		+ " and (ci.city_name like '%${keyWord}%' "
		+ "or ci.local_city_name like '%${keyWord}%' "
		+ "or co.country_name like '%${keyWord}%') "
		+ "</if>"
		+ "</where>"
		+ "<choose>"
		+ "<when test='orderBy != \"\" and orderBy != null'>"
		+ " order by ${orderBy} ${direction}"
		+ "</when>"
		+ "<otherwise>"
		+ " order by city_id desc"
		+ "</otherwise>"
		+ "</choose>"
		+ "</script>")
	List<City> getCitiesBySearchBean(SearchBean searchBean);
}
