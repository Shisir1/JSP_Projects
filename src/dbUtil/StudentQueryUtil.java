package dbUtil;

import java.sql.*;

public class StudentQueryUtil {

	private static Connection connection;
	private ResultSet resultset;
	private int deleted;
	
	public static void ConnectToDB() {
		try {
			// Load the JDBC driver
		    //Class.forName("com.mysql.jdbc.Driver");
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    System.out.println("Driver loaded");
		    connection = DriverManager.getConnection
		    	      ("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;" , "cst4713", "password1");
		    System.out.println("Database connected");
		}
		catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("Database connected");
		}
	}
	
	public ResultSet findAllCourses(String query) throws SQLException, ClassNotFoundException {
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
    
	public ResultSet findStudentQuery(String query) throws SQLException, ClassNotFoundException {
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
	
	public ResultSet findStudentCoursesQuery(String query) throws SQLException, ClassNotFoundException {
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
	
	//Perform Update Statement into table enrollmeent 
	public void addClassQuery(String query) throws SQLException, ClassNotFoundException{
		try {
			//connectionDB();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			
			System.out.println("printing add class statement " + query);
		}
		catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
	
	//Perform Delete/ Update Statement into table enrollment
	public int dropClassQuery(String query) throws SQLException, ClassNotFoundException{
		try {
			//connectionDB();
			Statement statement = connection.createStatement();
			System.out.println("printing statement " + query);
			deleted = statement.executeUpdate(query);
			
		}
		catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		return deleted;
		
	}
   
   public void closeConn() throws SQLException {
	   connection.close();
   }
}
