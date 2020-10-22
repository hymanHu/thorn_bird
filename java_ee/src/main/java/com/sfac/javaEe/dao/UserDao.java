package com.sfac.javaEe.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sfac.javaEe.entity.User;
import com.sfac.javaEe.util.DBUtil;


/**
 * @Description: User Dao
 * @author: HymanHu
 * @date: 2020年10月22日
 */
public class UserDao {

	/**
	 * -根据userName查询user
	 */
	public User getUserByUserName(String userName) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where user_name = ?";
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	/**
	 * -根据用户名和密码查询 user
	 */
	public User getUserByUserNameAndPassword(String userName, String password) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where user_name = ? and password = ?";
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	/**
	 * -根据userId查询user
	 */
	public User getUserByUserId(int userId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where user_id = ?";
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
			}
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	/**
	 * -插入user，并返回有id的user
	 */
	public User insertUser(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user (user_name, password, create_date) values (?, ?, ?)";
		
		try {
			/*
			 * -从5.1.17版本之后的mysql-connector增加了返回GeneratedKeys的条件，
			 * -如果需要返回GeneratedKeys，则PreparedStatement需要显示添加一个参数
			 * PreparedStatement.RETURN_GENERATED_KEYS
			 */
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setDate(3, new Date(user.getCreateDate().getTime()));
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
			}
			
			// 手动提交事务，默认是自动提交
//			conn.setAutoCommit(false);
//			conn.commit();
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	/**
	 * -更新user
	 */
	public User updateUser(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update user set user_name = ?, password = ? where user_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserId());
			ps.execute();
			
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return user;
	}
	
	/**
	 * -删除 user
	 */
	public void deleteUser(int userId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from user where user_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.execute();
			
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	/**
	 * -查询所有users
	 */
	public List<User> getUsers() throws SQLException {
		Connection connection = null;
		String sql = "select * from user";
		List<User> users = new ArrayList<User>();
		
		try {
			connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date"));
				users.add(user);
			}
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return users;
	}
}
