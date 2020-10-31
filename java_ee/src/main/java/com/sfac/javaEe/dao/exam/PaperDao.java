package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.sfac.javaEe.entity.exam.Paper;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Paper Dao
 * @author HymanHu
 * @date 2020-10-29 15:58:30
 */
public class PaperDao {
	
	public Paper getPaperById(int id) throws SQLException {
		Paper paper = null;
		Connection connection = DBUtil.getConnection();
		String sql = "select * from paper where id = ?";
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setSubject(rs.getString("subject"));
				paper.setCreateDate(new Date(rs.getDate("create_date").getTime()));
				paper.setTotalTime(rs.getInt("total_time"));
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return paper;
	}

}
