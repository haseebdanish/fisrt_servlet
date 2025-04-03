package org.cms.datasources;
import java.sql.*;

public class MysqlDBConnection {
	private Connection connection;
	// Constructor
	public MysqlDBConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TechM","root","D@nish00");
	}
	//Setter & Getter
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
