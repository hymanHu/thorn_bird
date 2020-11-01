package com.sfac.javaEe.dao.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.common.SearchVo;
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
	
	public List<Paper> getPapersBySearchVo(SearchVo searchVo) throws SQLException {
		List<Paper> papers = new ArrayList<Paper>();
		Connection connection = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from paper ");
		if (StringUtils.isNotBlank(searchVo.getKeyWord())) {
			sql.append("where subject like '%" + searchVo.getKeyWord() + "%' ");
		}
		sql.append("order by ")
			.append(StringUtils.isNotBlank(searchVo.getOrderBy()) ? searchVo.getOrderBy() + " " : " id ")
			.append(StringUtils.isNotBlank(searchVo.getSort()) ? searchVo.getSort() + " " : " ASC ")
			.append("limit ")
			.append((searchVo.getCurrentPage() - 1) * searchVo.getPageSize())
			.append(" , ")
			.append(searchVo.getCurrentPage() * searchVo.getPageSize());
		
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

}
