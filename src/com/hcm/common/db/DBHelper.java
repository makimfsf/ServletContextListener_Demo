package com.hcm.common.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.hcm.common.utils.PropertiesFactory;
import com.mysql.jdbc.Connection;

/**
 * DB辅助类
 * 
 * @author huangcongmin
 * @version , 2013-7-29
 * @since
 */
public class DBHelper {

	private String driverClass = "";
	private String url = "";
	private String username = "";
	private String password = "";
	private Connection connection = null;
	private PropertiesFactory propertiesFactory = null;

	public DBHelper() {
		propertiesFactory = PropertiesFactory.getInstance();
		this.driverClass = propertiesFactory.getConfig("jdbc.driverClass");
		this.url = propertiesFactory.getConfig("jdbc.url");
		this.username = propertiesFactory.getConfig("jdbc.username");
		this.password = propertiesFactory.getConfig("jdbc.password");
		try {
			Class.forName(this.driverClass);
			this.connection = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void close() {
		if (this.connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
