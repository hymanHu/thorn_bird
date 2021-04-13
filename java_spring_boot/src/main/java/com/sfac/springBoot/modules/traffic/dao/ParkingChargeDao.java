package com.sfac.springBoot.modules.traffic.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.traffic.entity.ParkingCharge;

/**
 * @Description: Parking Charge Dao
 * @author: HymanHu
 * @date: 2021年3月21日
 */
@Mapper
@Repository
public interface ParkingChargeDao {
	
	@Insert("insert into traffic_parking_charge (car_license, charge_type, "
			+ "parking_id, start, end, sum, fee, create_date) "
			+ "values (#{carLicense}, #{chargeType}, #{parkingId}, #{start}, "
			+ "#{end}, #{sum}, #{fee}, #{createDate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insertParkingCharge(ParkingCharge parkingCharge);
	
	@Update("update traffic_parking_charge set car_license = #{carLicense}, charge_type = #{chargeType}, "
			+ "parking_id = #{parkingId}, start = #{start}, end = #{end}, sum = #{sum}, fee = #{fee} where id = #{id}")
	void updateParkingCharge(ParkingCharge parkingCharge);
	
	@Delete("delete from traffic_parking_charge where id = #{id}")
	void deleteParkingCharge(int id);
	
	@Select("select * from traffic_parking_charge where id = #{id}")
	ParkingCharge getParkingChargeById(int id);
	
	@Select("<script>"
			+ "select * from traffic_parking_charge "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (car_license like '%${keyWord}%') "
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
	List<ParkingCharge> getParkingChargesBySearchBean(SearchBean searchBean);
	
	@Select("select * from traffic_parking_charge where car_license = #{carLicense} "
			+ "and charge_type = 1 order by end desc limit 1")
	ParkingCharge getLastLongTimeChargeByCarLicense(String carLicense);
	
	@Select("select * from traffic_parking_charge where start < #{end} and end > #{start} "
			+ "and car_license = #{carLicense} order by end desc")
	List<ParkingCharge> getRepeatParkingCharges(
			@Param("start") LocalDateTime start, 
			@Param("end") LocalDateTime end, 
			@Param("carLicense") String carLicense);

}
