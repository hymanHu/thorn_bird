package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchVo;
import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Question Dao
 * @author HymanHu
 * @date 2020-11-05 21:48:16
 */
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
	
	public List<Question> getQuestionsBySearchVo(SearchVo searchVo) throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		Connection connection = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from question ");
		if (StringUtils.isNotBlank(searchVo.getKeyWord())) {
			sql.append("where content like '%" + searchVo.getKeyWord() + "%' or ");
			sql.append("type like '%" + searchVo.getKeyWord() + "%' or ");
			sql.append("flag like '%" + searchVo.getKeyWord() + "%' ");
		}
		sql.append("order by ")
			.append(StringUtils.isNotBlank(searchVo.getOrderBy()) ? searchVo.getOrderBy() + " " : " id ")
			.append(StringUtils.isNotBlank(searchVo.getSort()) ? searchVo.getSort() + " " : " ASC ")
			.append("limit ")
			.append((searchVo.getCurrentPage() - 1) * searchVo.getPageSize())
			.append(" , ")
			.append(searchVo.getCurrentPage() * searchVo.getPageSize());
		
		System.out.println(sql.toString());
		
		PreparedStatement ps = null;
		try {
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
	
	public int getQuestionsCountBySearchVo(SearchVo searchVo) throws SQLException {
		Connection connection = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from question ");
		if (StringUtils.isNotBlank(searchVo.getKeyWord())) {
			sql.append("where content like '%" + searchVo.getKeyWord() + "%' or ");
			sql.append("type like '%" + searchVo.getKeyWord() + "%' or ");
			sql.append("flag like '%" + searchVo.getKeyWord() + "%' ");
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
