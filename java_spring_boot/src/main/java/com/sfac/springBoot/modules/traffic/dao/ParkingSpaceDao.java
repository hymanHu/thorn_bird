package com.sfac.springBoot.modules.traffic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.entity.ParkingSpace;

/**
 * Description: Parking Space Dao
 * @author HymanHu
 * @date 2021-03-12 15:16:07
 */
@Mapper
@Repository
public interface ParkingSpaceDao {

	@Insert("insert into traffic_parking_space (parking_space_type, status, create_date) "
			+ "values (#{parkingSpaceType}, #{status}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertParkingSpace(ParkingSpace parkingSpace);
	
	@Update("update traffic_parking_space set parking_space_type = #{parkingSpaceType}, "
			+ "status = #{status} where id = #{id}")
	void updateParkingSpace(ParkingSpace parkingSpace);
	
	@Delete("delete from traffic_parking_space where id = #{id}")
	void deleteParkingSpaceById(int id);
	
	@Select("select * from traffic_parking_space where id = #{id}")
	ParkingSpace getParkingSpaceById(int id);
	
	@Select("select * from traffic_parking_space where status = #{status}")
	List<ParkingSpace> getParkingSpacesByStatus(int status);
	
	@Select("<script>"
			+ "select * from traffic_parking_space "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (parking_space_type like '%${keyWord}%') "
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
	List<ParkingSpace> getParkingSpacesBySearchBean(SearchBean searchBean);
}
