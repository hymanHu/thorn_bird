package com.sfac.springMvc.module.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.common.entity.SearchBean;

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
	
	@Select("select * from account_user where email = #{email} or user_name = #{userName}")
	List<User> getUserByUserName(@Param("email") String email, @Param("userName") String userName);
	
	@Insert("insert into account_user (email, user_name, password, create_date) "
			+ "values (#{email}, #{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertUser(User user);
	
	@Update("update account_user set email = #{email}, user_name = #{userName} where id = #{id}")
	void updateUser(User user);
	
	@Select("select * from account_user where id = #{id}")
	@Results(id="userResult", value={
		@Result(column="id", property="id"),
		@Result(column="id",property="roles",
			javaType=List.class,
			many=@Many(select="com.sfac.springMvc.module.account.dao.RoleDao.getRolesByUserId"))
	})
	User getUserById(int id);
	
	@Delete("delete from account_user where id = #{id}")
	void deleteUserById(int id);
	
	@Select("<script>"
			+ "select * from account_user "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (email like '%${keyWord}%' or "
			+ " user_name like '%${keyWord}%') "
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
	List<User> getUsersBySearchVo(SearchBean searchBean);
}
