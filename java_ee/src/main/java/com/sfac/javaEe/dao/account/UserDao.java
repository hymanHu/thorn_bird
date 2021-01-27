package com.sfac.javaEe.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sfac.javaEe.entity.account.User;
import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.util.DBUtil;


/**
 * @Description: User Dao
 * @author: HymanHu
 * @date: 2020年10月22日
 */
public class UserDao {

	// 根据 userName 查询 user
	public User getUserByUserName(String userName) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "select * from account_user where user_name = ?";
		User user = null;
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getTimestamp("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	// 根据用户名和密码查询 user
	public User getUserByUserNameAndPassword(String userName, String password) 
			throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "select * from account_user where user_name = ? and password = ?";
		User user = null;
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getTimestamp("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	// 根据 userId 查询 user
	public User getUserByUserId(int userId) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "select * from account_user where id = ?";
		User user = null;
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getTimestamp("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	// 插入user，并返回有 id 的 user
	public User insertUser(User user) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "insert into account_user (user_name, password, create_date) values (?, ?, ?)";
		
		try {
			conn = DBUtil.getConnection();
			/*
			 * -从5.1.17版本之后的mysql-connector增加了返回GeneratedKeys的条件，
			 * -如果需要返回GeneratedKeys，则PreparedStatement需要显示添加一个参数
			 * PreparedStatement.RETURN_GENERATED_KEYS
			 */
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setTimestamp(3, new Timestamp(user.getCreateDate().getTime()));
			System.out.println(ps.toString());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				user.setId(rs.getInt(1));
			}
			
			// 手动提交事务，默认是自动提交
//			conn.setAutoCommit(false);
//			conn.commit();
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	// 更新 user
	public User updateUser(User user) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "update account_user set user_name = ?, password = ? where id = ?";
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());
			System.out.println(ps.toString());
			ps.execute();
			
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	// 删除 user
	public void deleteUser(int userId) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String sql = "delete from account_user where id = ?";
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			System.out.println(ps.toString());
			ps.execute();
			
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	// 根据 searchBean 查询所有 users
	public List<User> getUsersBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		StringBuffer sql = new StringBuffer("select * from account_user ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where user_name like '%" + searchBean.getKeyWord() + "%'");
		}
		sql.append("order by ")
			.append(StringUtils.isNotBlank(searchBean.getOrderBy()) ? searchBean.getOrderBy() + " " : " id ")
			.append(StringUtils.isNotBlank(searchBean.getDirection()) ? searchBean.getDirection() + " " : " ASC ")
			.append("limit ")
			.append((searchBean.getCurrentPage() - 1) * searchBean.getPageSize())
			.append(" , ")
			.append(searchBean.getPageSize());
		
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getTimestamp("create_date"));
				users.add(user);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return users;
	}
	
	// 根据 searchBean 查询 users 总数
	public int getUsersCountBySearchBean(SearchBean searchBean) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		StringBuffer sql = new StringBuffer("select count(*) from account_user ");
		if (StringUtils.isNotBlank(searchBean.getKeyWord())) {
			sql.append("where user_name like '%" + searchBean.getKeyWord() + "%'");
		}
		
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
}
