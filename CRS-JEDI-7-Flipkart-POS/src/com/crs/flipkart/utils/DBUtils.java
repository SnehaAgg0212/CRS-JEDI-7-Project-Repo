/**
 * 
 */
package com.crs.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author devanshugarg
 *
 */
public class DBUtils {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		if (connection != null) {
			try {
				if (connection.isClosed()) {	
					connection = null;
					return getConnection();
				} else {
				return connection;
				}
			} catch (SQLException e) {
				return getConnection();
			}
		} else {
			try {
				Properties properties = new Properties();
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/test";
				String username = "root";
				String password = "root";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}
