package com.sfac.javaEe.dao.spider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sfac.javaEe.entity.spider.Coronavirus;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Coronavirus Dao
 * @author HymanHu
 * @date 2020-10-23 13:58:59
 */
public class CoronavirusDao {

	public List<Coronavirus> getCoronavirusList() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		String sql = "select * from coronavirus order by date desc limit 7";
		List<Coronavirus> coronavirusList = new ArrayList<Coronavirus>();
		
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Coronavirus coronavirus = new Coronavirus();
				coronavirus.setId(rs.getInt("id"));
				coronavirus.setDate(rs.getString("date"));
				coronavirus.setRegion(rs.getString("region"));
				coronavirus.setDiagnosis(rs.getInt("diagnosis"));
				coronavirus.setOverseasImport(rs.getInt("overseas_import"));
				coronavirus.setCure(rs.getInt("cure"));
				coronavirus.setDeath(rs.getInt("death"));
				coronavirus.setObservation(rs.getInt("observation"));
				coronavirus.setTherapy(rs.getInt("therapy"));
				coronavirusList.add(coronavirus);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return coronavirusList;
	}
}
