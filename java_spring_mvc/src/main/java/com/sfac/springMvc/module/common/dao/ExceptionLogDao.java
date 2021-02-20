package com.sfac.springMvc.module.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.common.entity.ExceptionLog;

/**
 * Description: Exception Log Dao
 * @author HymanHu
 * @date 2021-01-29 14:01:11
 */
@Mapper
@Repository
public interface ExceptionLogDao {

	@Insert("insert into common_exception_log (create_date, ip, path, class_name, method_name, exception_type, "
			+ "exception_message) values (#{createDate}, #{ip}, #{path}, #{className}, #{methodName}, "
			+ "#{exceptionType}, #{exceptionMessage})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertExceptionLog(ExceptionLog exceptionLog);
	
	@Select("select * from common_exception_log where class_name = #{className} and method_name = #{methodName} "
			+ "and exception_type = #{exceptionType} and exception_message = #{exceptionMessage}")
	List<ExceptionLog> getExceptionLogsByParameters(ExceptionLog exceptionLog);
}
