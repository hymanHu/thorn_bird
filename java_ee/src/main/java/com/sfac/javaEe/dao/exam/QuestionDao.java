package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.entity.exam.PaperBuilder;
import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Question Dao
 * @author HymanHu
 * @date 2020-11-05 21:48:16
 */
public class QuestionDao {
	
	public void insertQuestion(Question question) throws SQLException, ClassNotFoundException {
		String sql = "insert into exam_question (type, flag, content, score, option_a, option_b, option_c, "
				+ "option_d, reference_answer, comment) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
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
			System.out.println(ps.toString());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				question.setId(rs.getInt(1));
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public Question getQuestionById(int id) throws ClassNotFoundException, SQLException {
		Question question = null;
		String sql = "select * from exam_question where id = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				question = new Question();
				question.setId(rs.getInt("id"));
				question.setType(rs.getString("type"));
				question.setFlag(rs.getString("flag"));
				question.setContent(rs.getString("content"));
				question.setScore(rs.getDouble("score"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_d"));
				question.setReferenceAnswer(rs.getString("reference_answer"));
				question.setComment(rs.getString("comment"));
				System.out.println(ps.toString());
				break;
			}
		} finally {
			conn.close();
		}
		
		return question;
	}
	
	public void updateQuestion(Question question) throws ClassNotFoundException, SQLException {
		String sql = "update exam_question set type = ?, flag = ?, content = ?, score = ?, option_a = ?, "
				+ "option_b = ?, option_c = ?, option_d = ?, reference_answer = ?, comment = ? where id = ?";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, question.getType());
			ps.setString(2, question.getFlag());
			ps.setString(3, question.getContent());
			ps.setDouble(4, question.getScore());
			ps.setString(5, question.getOptionA());
			ps.setString(6, question.getOptionB());
			ps.setString(7, question.getOptionC());
			ps.setString(8, question.getOptionD());
			ps.setString(9, question.getReferenceAnswer());
			ps.setString(10, question.getComment());
			ps.setInt(11, question.getId());
			System.out.println(ps.toString());
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void deleteQuestionById(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from exam_question where id = ?";
		
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

	public List<Question> getQuestionsByPaperId(int paperId) throws SQLException, ClassNotFoundException {
		List<Question> questions = new ArrayList<Question>();
		String sql = "select * from exam_question q left join exam_paper_question pq on q.id = pq.question_id "
				+ "where pq.paper_id = ? order by type";
		
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
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
				System.out.println(ps.toString());
				questions.add(question);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return questions;
	}
	
	public List<Question> getQuestionsBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		List<Question> questions = new ArrayList<Question>();
		StringBuffer sql = new StringBuffer("select * from exam_question ");
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
		
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			System.out.println(ps.toString());
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
	
	public int getQuestionsCountBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		StringBuffer sql = new StringBuffer("select count(*) from exam_question ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where content like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("type like '%" + searchBean.getKeyWord() + "%' or ");
			sql.append("flag like '%" + searchBean.getKeyWord() + "%' ");
		}
		
		Connection connection = null;
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return count;
	}
	
	public List<Question> getQuestionsByPaperBuilder(PaperBuilder paperBuilder) 
			throws ClassNotFoundException, SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from exam_question where flag = '")
			.append(paperBuilder.getPaperFlage())
			.append("' ");
		if (paperBuilder.getPaperTypes() != null && !paperBuilder.getPaperTypes().isEmpty()) {
			sb.append("and type in (")
				.append(String.join(",", paperBuilder.getPaperTypes()
						.stream().map(item -> String.format("'%s'", item)).collect(Collectors.toList())))
				.append(") ");
		}
		sb.append("order by type");
		
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			System.out.println(ps.toString());
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
			DBUtil.closeConnection(conn);
		}
			
		return questions;
	}
}
