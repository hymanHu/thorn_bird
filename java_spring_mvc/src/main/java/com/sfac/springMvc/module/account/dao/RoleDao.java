package com.sfac.springMvc.module.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.Role;
import com.sfac.springMvc.module.common.entity.SearchBean;

/**
 * Description: Role Dao
 * @author HymanHu
 * @date 2021-01-28 09:24:14
 */
@Repository
@Mapper
public interface RoleDao {
	
	@Insert("insert into account_role (role_name, create_date) values (#{roleName}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertRole(Role role);
	
	@Update("update account_role set role_name = #{roleName} where id = #{id}")
	void updateRole(Role role);
	
	@Delete("delete account_role where id = #{id}")
	void deleteRoelById(int id);
	
	@Select("select * from account_role where id = #{id}")
	Role getRoleById(int id);

	@Select("select * from account_role ar left join account_user_role aur on ar.id = aur.role_id "
			+ "where aur.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
	
	@Select("select * from account_role")
	List<Role> getRoles();
	
	@Select("<script>"
			+ "select * from account_role "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (role_name like '%${keyWord}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ " order by ${orderBy} ${direction}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<Role> getRolesBySearchBean(SearchBean searchBean);
}
