package com.sfac.springMvc.module.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.UserRole;

/**
 * Description: User Role Dao
 * @author HymanHu
 * @date 2021-02-01 09:50:03
 */
@Mapper
@Repository
public interface UserRoleDao {

	@Delete("delete from account_user_role where user_id = #{userId}")
	void deleteUserRoleByUserId(int userId);
	
	@Insert("insert into account_user_role (user_id, role_id) values (#{userId}, #{roleId})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertUserRole(UserRole userRole);
}
