package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.entity.exam.Paper;
import com.sfac.javaEe.util.DBUtil;

/**
 * Description: Paper Dao
 * @author HymanHu
 * @date 2020-10-29 15:58:30
 */
public class PaperDao {
	
	public void insertPager(Paper paper) throws ClassNotFoundException, SQLException {
		String sql = "insert into paper (subject, total_time, create_date) value (?, ?, ?)";
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, paper.getSubject());
			ps.setInt(2, paper.getTotalTime());
			ps.setTimestamp(3, new Timestamp(paper.getCreateDate().getTime()));
			System.out.println(ps.toString());
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				paper.setId(rs.getInt("id"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public Paper getPaperById(int id) throws SQLException, ClassNotFoundException {
		Paper paper = null;
		String sql = "select * from paper where id = ?";
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DBUtil.getConnection();
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
	
	public List<Paper> getPapersBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		List<Paper> papers = new ArrayList<Paper>();
		StringBuffer sql = new StringBuffer("select * from paper ");
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
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setSubject(rs.getString("subject"));
				paper.setTotalTime(rs.getInt("total_time"));
				paper.setCreateDate(rs.getDate("create_date"));
				papers.add(paper);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return papers;
	}
	
	public int getPapersCountBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		StringBuffer sql = new StringBuffer("select count(*) from paper ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where subject like '%" + searchBean.getKeyWord() + "%' ");
		}
		
		Connection connection = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			ps = connection.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return count;
	}
	
	public void deletePaperById(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from paper where id = ?";
		System.out.println(sql);
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
}
