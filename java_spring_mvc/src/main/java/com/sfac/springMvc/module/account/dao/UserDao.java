package com.sfac.springMvc.module.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
	
	@Select("select * from account_user where user_name = #{userName}")
	User getUserByUserName(String userName);
	
	@Insert("insert into account_user (user_name, password, create_date) "
			+ "values (#{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertUser(User user);
	
	@Update("update account_user set user_name = #{userName}, password = #{password} where id = #{id}")
	void updateUser(User user);
	
	@Select("select * from account_user where id = #{id}")
	User getUserById(int id);
	
	@Delete("delete from account_user where id = #{id}")
	void deleteUserById(int id);
	
	@Select("<script>"
			+ "select * from account_user "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (user_name like '%${keyWord}%') "
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
