package com.sfac.springMvc.dao;

import com.sfac.springMvc.entity.Country;
import com.sfac.springMvc.entity.CountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Description: Country Mapper
 * @author HymanHu
 * @date 2020-12-09 11:18:06
 */
public interface CountryMapper {
    long countByExample(CountryExample example);

    int deleteByExample(CountryExample example);

    int deleteByPrimaryKey(Integer countryId);

    int insert(Country record);

    int insertSelective(Country record);

    List<Country> selectByExample(CountryExample example);

    Country selectByPrimaryKey(Integer countryId);

    int updateByExampleSelective(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByExample(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}