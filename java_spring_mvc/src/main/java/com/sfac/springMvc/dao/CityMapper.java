package com.sfac.springMvc.dao;

import com.sfac.springMvc.entity.City;
import com.sfac.springMvc.entity.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Description: City Mapper
 * @author HymanHu
 * @date 2020-12-09 11:17:50
 */
public interface CityMapper {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}