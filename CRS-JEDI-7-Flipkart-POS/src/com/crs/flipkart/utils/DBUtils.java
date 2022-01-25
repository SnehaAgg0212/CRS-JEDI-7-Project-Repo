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
		
		return connection;
	}
}
