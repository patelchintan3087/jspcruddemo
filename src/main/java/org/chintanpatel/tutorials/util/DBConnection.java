/**
 * Created by IntelliJ IDEA.
 * User: chintanpatel
 * Date: 28/07/22
 * Time: 2:43 pm
 * To change this template use File | Settings | File Templates.
 */
package org.chintanpatel.tutorials.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String USER = "root";
	private static final String PASSWORD = "root1320";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			if (connection == null) {
				System.out.println("Can not connect to database.");
			} else {
				System.out.println("Connect to database.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
