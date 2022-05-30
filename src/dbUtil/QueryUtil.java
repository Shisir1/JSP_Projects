package dbUtil;

import java.sql.*;

public class QueryUtil {
	private static Connection connection;
	private ResultSet resultset;
	
	public static void ConnectToDB(String userID, String password) {
		try {
			// Load the JDBC driver
		    //Class.forName("com.mysql.jdbc.Driver");
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    System.out.println("Driver loaded");
		    connection = DriverManager.getConnection
		    	      ("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;"+ "databaseName=CUNY_DB;integratedSecurity=false;" , userID, password);
		    System.out.println("Database connected");
		}
		catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("Database connected");
		}
	}
    
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException {
		try {
			//connectionDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}
		catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}
	
	public void updateValues(String table, String query) throws SQLException, ClassNotFoundException{
		try {
			//connectionDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}
		catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
   
   public void closeConn() throws SQLException {
	   connection.close();
   }
}
