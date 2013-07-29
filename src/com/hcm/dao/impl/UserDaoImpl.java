package com.hcm.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcm.common.db.DBHelper;
import com.hcm.dao.UserDao;
import com.hcm.domain.User;

public class UserDaoImpl implements UserDao {

	public void save(User user) throws Exception {
		String sql = "insert into user(username, password) values(?, ?)";
		DBHelper dbHelper = new DBHelper();
		try {
			PreparedStatement pstmt = dbHelper.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.close();
		}
	}

	public User get(Long id) {
		String sql = "select * from user where user.id = ?";
		DBHelper dbHelper = new DBHelper();
		User user = null;
		try {
			PreparedStatement pstmt = dbHelper.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(id);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.close();
		}
		return user;
	}

}
