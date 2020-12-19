package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Question Dao
 * @author HymanHu
 * @date 2020-11-05 21:48:16
 */
public class QuestionDao {
	
	public void insertQuestion(Question question) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = "insert into question (type, flag, content, score, option_a, option_b, option_c, "
				+ "option_d, reference_answer, comment) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, question.getType());
			ps.setString(2, question.getFlag());
			ps.setString(3, question.getContent());
			ps.setFloat(4, question.getScore().floatValue());
			ps.setString(5, question.getOptionA());
			ps.setString(6, question.getOptionB());
			ps.setString(7, question.getOptionC());
			ps.setString(8, question.getOptionD());
			ps.setString(9, question.getReferenceAnswer());
			ps.setString(10, question.getComment());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				question.setId(rs.getInt(1));
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public List<Question> getQuestionsByPaperId(int paperId) throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from question q left join paper_question pq on q.id = pq.question_id "
				+ "where pq.paper_id = ?";
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
	
	public List<Question> getQuestionsBySearchBean(SearchBean searchBean) throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		Connection connection = null;
		StringBuffer sql = new StringBuffer("select * from question ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where content like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("type like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("flag like '%" + searchBean.getKeyWord() + "%' ");
		}
		sql.append("order by ")
			.append(StringUtils.isNotBlank(searchBean.getOrderBy()) ? searchBean.getOrderBy() + " " : " id ")
			.append(StringUtils.isNotBlank(searchBean.getDirection()) ? searchBean.getDirection() + " " : " ASC ")
			.append("limit ")
			.append((searchBean.getCurrentPage() - 1) * searchBean.getPageSize())
			.append(" , ")
			.append(searchBean.getPageSize());
		
		System.out.println(sql.toString());
		
		PreparedStatement ps = null;
		try {
			connection = DBUtil.getConnection();
			ps = connection.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setType(rs.getString("type"));
				question.setFlag(rs.getString("flag"));
				question.setContent(rs.getString("content"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_d"));
				question.setReferenceAnswer(rs.getString("reference_answer"));
				question.setComment(rs.getString("comment"));
				question.setScore(rs.getDouble("score"));
				questions.add(question);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return questions;
	}
	
	public int getQuestionsCountBySearchBean(SearchBean searchBean) throws SQLException {
		Connection connection = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select count(*) from question ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where content like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("type like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("flag like '%" + searchBean.getKeyWord() + "%' ");
		}
		System.out.println(sql.toString());
		
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = connection.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return count;
	}
}
