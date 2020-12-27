package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.sfac.javaEe.entity.exam.Achievement;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Achievement Dao
 * @author HymanHu
 * @date 2020-12-25 19:32:49
 */
public class AchievementDao {

	public void insertAchievement(Achievement achievement) throws ClassNotFoundException, SQLException {
		String sql = "insert into achievement (user_id, subject, total_score, reference_score, "
				+ "score, total_time, spend_time, exam_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, achievement.getUserId());
			ps.setString(2, achievement.getSubject());
			ps.setDouble(3, achievement.getTotalScore());
			ps.setString(4, achievement.getReferenceScore());
			ps.setDouble(5, achievement.getScore());
			ps.setInt(6, achievement.getTotalTime());
			ps.setInt(7, achievement.getSpendTime());
			ps.setTimestamp(8, new Timestamp(achievement.getExamDate().getTime()));
			System.out.println(ps.toString());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				achievement.setId(rs.getInt(1));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
}
