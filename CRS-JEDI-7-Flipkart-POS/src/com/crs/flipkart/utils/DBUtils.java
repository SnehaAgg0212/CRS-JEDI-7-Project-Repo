/**
 * 
 */
package com.crs.flipkart.utils;
import java.lang.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
				InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
				properties.load(inputStream);
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/test";
//				String driver=properties.getProperty("driver");
//				String url=properties.getProperty("url");
//				
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}
