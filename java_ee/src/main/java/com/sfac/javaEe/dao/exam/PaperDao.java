package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public Paper getPaperById(int id) throws SQLException {
		Paper paper = null;
		Connection connection = DBUtil.getConnection();
		String sql = "select * from paper where id = ?";
		
		PreparedStatement ps = null;
		try {
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
	
	public List<Paper> getPapersBySearchBean(SearchBean searchBean) throws SQLException {
		List<Paper> papers = new ArrayList<Paper>();
		Connection connection = DBUtil.getConnection();
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
			.append(searchBean.getCurrentPage() * searchBean.getPageSize());
		
		PreparedStatement ps = null;
		try {
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
	
	public int getPapersCountBySearchBean(SearchBean searchBean) throws SQLException {
		Connection connection = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select count(*) from paper ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where subject like '%" + searchBean.getKeyWord() + "%' ");
		}
		
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
