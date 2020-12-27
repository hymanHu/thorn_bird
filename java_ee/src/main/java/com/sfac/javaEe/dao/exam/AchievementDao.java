package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchBean;
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
	
	public void deleteAchievementById(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from achievement where id = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println(ps.toString());
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public List<Achievement> getAchievementsBySearchBean(SearchBean searchBean) 
			throws ClassNotFoundException, SQLException {
		List<Achievement> achievements = new ArrayList<Achievement>();
		StringBuffer sql = new StringBuffer("select * from achievement a "
				+ "left join user u on a.user_id = u.user_id ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where subject like '%" + searchBean.getKeyWord() + "%' ");
		}
		sql.append("order by ")
			.append(StringUtils.isNotBlank(searchBean.getOrderBy()) ? searchBean.getOrderBy() + " " : " id ")
			.append(StringUtils.isNotBlank(searchBean.getDirection()) ? searchBean.getDirection() + " " : " ASC ")
			.append("limit ")
			.append((searchBean.getCurrentPage() - 1) * searchBean.getPageSize())
			.append(" , ")
			.append(searchBean.getPageSize());
		
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			ps = connection.prepareStatement(sql.toString());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Achievement achievement = new Achievement();
				achievement.setId(rs.getInt("id"));
				achievement.setUserId(rs.getInt("user_id"));
				achievement.setSubject(rs.getString("subject"));
				achievement.setTotalScore(rs.getDouble("total_score"));
				achievement.setReferenceScore(rs.getString("reference_score"));
				achievement.setScore(rs.getDouble("score"));
				achievement.setTotalTime(rs.getInt("total_time"));
				achievement.setSpendTime(rs.getInt("spend_time"));
				achievement.setExamDate(rs.getTimestamp("exam_date"));
				achievement.setUserName(rs.getString("user_name"));
				achievements.add(achievement);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return achievements;
	}
	
	public int getAchievementsCountBySearchBean(SearchBean searchBean) 
			throws ClassNotFoundException, SQLException {
		StringBuffer sql = new StringBuffer("select count(*) from achievement ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where subject like '%" + searchBean.getKeyWord() + "%' ");
		}
		
		PreparedStatement ps = null;
		Connection connection = null;
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			ps = connection.prepareStatement(sql.toString());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return count;
	}
}
