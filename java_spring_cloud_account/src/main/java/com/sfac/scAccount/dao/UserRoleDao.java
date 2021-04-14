package com.sfac.scAccount.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.sfac.common.entity.account.UserRole;

/**
 * @Description: User Role Dao
 * @author: HymanHu
 * @date: 2021年2月21日
 */
@Mapper
@Repository
public interface UserRoleDao {
	
	@Insert("insert into account_user_role (user_id, role_id) values (#{userId}, #{roleId})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertUserRole(UserRole userRole);

	@Delete("delete from account_user_role where user_id = #{userId}")
	void deleteUserRoleByUserId(int userId);
	
	@Delete("delete from account_user_role where role_id = #{roleId}")
	void deleteUserRoleByRoleId(int roleId);
}
