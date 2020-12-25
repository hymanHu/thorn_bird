package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.sfac.javaEe.entity.exam.Exam;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Exam Dao
 * @author HymanHu
 * @date 2020-12-25 19:32:49
 */
public class ExamDao {

	public void insertExam(Exam exam) throws ClassNotFoundException, SQLException {
		String sql = "insert into exam (user_id, subject, total_score, reference_score, "
				+ "score, total_time, spend_time, exam_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, exam.getUserId());
			ps.setString(2, exam.getSubject());
			ps.setDouble(3, exam.getTotalScore());
			ps.setString(4, exam.getReferenceScore());
			ps.setDouble(5, exam.getScore());
			ps.setInt(6, exam.getTotalTime());
			ps.setInt(7, exam.getSpendTime());
			ps.setTimestamp(8, new Timestamp(exam.getExamDate().getTime()));
			System.out.println(ps.toString());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				exam.setId(rs.getInt(1));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
//		return exam;
	}
}
