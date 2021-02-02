package com.sfac.springMvc.module.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.account.entity.Resource;
import com.sfac.springMvc.module.common.entity.SearchBean;

/**
 * Description: Resource Dao
 * @author HymanHu
 * @date 2021-02-01 10:03:39
 */
@Mapper
@Repository
public interface ResourceDao {

	@Insert("insert into account_resource (permission, create_date) values (#{permission}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertResource(Resource resource);
	
	@Update("update account_resource set permission = #{permission} where id = #{id}")
	void updateResource(Resource resource);
	
	@Delete("delete from account_resource where id = #{id}")
	void deleteResourceById(int id);
	
	@Select("select * from account_resource where id = #{id}")
	@Results(id="resourceResult", value={
			@Result(column="id", property="id"),
			@Result(column="id",property="roles",
				javaType=List.class,
				many=@Many(select="com.sfac.springMvc.module.account.dao.RoleDao.getRolesByResourceId"))
		})
	Resource getResourceById(int id);
	
	@Select("select * from account_resource ar left join account_role_resource arr on ar.id = arr.resource_id "
			+ "where arr.role_id = #{roleId}")
	List<Resource> getResourcesByRoleId(int roleId);
	
	@Select("<script>"
			+ "select * from account_resource "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (permission like '%${keyWord}%') "
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
	List<Resource> getResourcesBySearchBean(SearchBean searchBean);
}
