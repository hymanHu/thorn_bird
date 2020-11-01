package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.util.DBUtil;

public class QuestionDao {

	public List<Question> getQuestionsByPaperId(int paperId) throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from question q left join paper_question pq on q.id = pq.question_id where pq.paper_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, paperId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setType(rs.getString("type"));
				question.setFlag(rs.getString("flag"));
				question.setScore(rs.getDouble("score"));
				question.setContent(rs.getString("content"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_D"));
				question.setReferenceAnswer(rs.getString("reference_answer"));
				question.setComment(rs.getString("comment"));
				questions.add(question);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return questions;
	}
}