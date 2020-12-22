package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Paper Question Dao
 * @author HymanHu
 * @date 2020-12-21 20:00:32
 */
public class PaperQuestionDao {
	
	public void insertPaperQestion(int paperId, int questionId) throws ClassNotFoundException, SQLException {
		String sql = "insert into paper_question (paper_id, question_id) values (?, ?)";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, paperId);
			ps.setInt(2, questionId);
			System.out.println(ps.toString());
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public void deletePaperQuestionByPaperId(int paperId) throws ClassNotFoundException, SQLException {
		String sql = "delete from paper_question where paper_id = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, paperId);
			System.out.println(ps.toString());
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
}
