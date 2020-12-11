package com.sfac.springMvc.module.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.test.entity.Country;

/**
 * Description: Country Dao
 * @author HymanHu
 * @date 2020-12-10 10:11:13
 */
@Repository
@Mapper
public interface CountryDao {
	
	/**
	 * @Results ---- 封装结果集，对于联表查询的字段，可调用已有的方法 getCitiesByCountryId
	 * column ---- 对应 select 查询后的某个字段名，作为映射实体 bean 属性或者作为调用方法的参数
	 * property ---- 对应 实体 bean 属性
	 * 1、country_id 封装了两次，分别对应 countryId 和 cities，
	 * -而 cities 属性通过 getCitiesByCountryId 方法来实现，country_id作为参数
	 * 2、结果集共享，设置 id 属性，调用时使用 @ResultMap(value="countryResults")
	 */
	@Select("select * from country where country_id = #{countryId}")
	@Results(id = "countryResults", value = {
		@Result(column = "country_id", property = "countryId"),
		@Result(column = "country_id", property = "cities", 
			javaType = List.class,
			many = @Many(select = "com.sfac.springMvc.dao.CityDao.getCitiesByCountryId")
		)
	})
	Country getCountryByCountryId(int countryId);
	
	@Select("select * from country where country_name = #{countryName}")
	@ResultMap(value = "countryResults")
	Country getCountryByCountryName(String countryName);

}
