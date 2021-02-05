package com.sfac.springMvc.module.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.RoleResource;

/**
 * Description: Role Resource Dao
 * @author HymanHu
 * @date 2021-02-01 10:09:48
 */
@Mapper
@Repository
public interface RoleResourceDao {
	
	@Insert("insert into account_role_resource (role_id, resource_id) values (#{roleId}, #{resourceId})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertRoleResource(RoleResource roleResource);
	
	@Delete("delete from account_role_resource where resource_id = #{resourceId}")
	void deleteRoleResourceByResourceId(int resourceId);
	
	@Delete("delete from account_role_resource where role_id = #{roleId}")
	void deleteRoleResourceByRoleId(int roleId);
}
