package com.sfac.springMvc.module.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.Role;

/**
 * Description: Role Dao
 * @author HymanHu
 * @date 2021-01-28 09:24:14
 */
@Repository
@Mapper
public interface RoleDao {

	@Select("select * from account_role ar left join account_user_role aur on ar.id = aur.role_id "
			+ "where aur.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
}
