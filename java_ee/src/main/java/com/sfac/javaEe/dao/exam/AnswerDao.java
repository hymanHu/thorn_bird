package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sfac.javaEe.entity.exam.Answer;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Answer Dao
 * @author HymanHu
 * @date 2020-12-25 19:45:09
 */
public class AnswerDao {

	public void insertAnswer(Answer answer) throws ClassNotFoundException, SQLException {
		String sql = "insert into answer (achievement_id, question_id, user_answer) values (?, ?, ?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, answer.getAchievementId());
			ps.setInt(2, answer.getQuestionId());
			ps.setString(3, answer.getUserAnswer());
			System.out.println(ps.toString());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			answer.setId(rs.getInt(1));
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void deleteAnswersByAchievementId(int achievementId) 
			throws ClassNotFoundException, SQLException {
		String sql = "delete from answer where achievement_id = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, achievementId);
			System.out.println(ps.toString());
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public List<Answer> getAnswersByAchievementId(int achievementId) 
			throws ClassNotFoundException, SQLException {
		String sql = "select * from answer where achievement_id = ?";
		
		List<Answer> answers = new ArrayList<Answer>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, achievementId);
			System.out.println(ps.toString());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Answer answer = new Answer();
				answer.setId(rs.getInt("id"));
				answer.setAchievementId(rs.getInt("achievement_id"));
				answer.setQuestionId(rs.getInt("question_id"));
				answer.setUserAnswer(rs.getString("user_answer"));
				answers.add(answer);
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return answers;
	}
}
