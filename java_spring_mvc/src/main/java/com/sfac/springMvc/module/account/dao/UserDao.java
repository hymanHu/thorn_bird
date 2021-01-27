package com.sfac.springMvc.module.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.User;

/**
 * Description: User Dao
 * @author HymanHu
 * @date 2021-01-27 09:48:22
 */
@Mapper
@Repository
public interface UserDao {

	@Select("select * from account_user where user_name = #{userName} and password = #{password}")
	User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
