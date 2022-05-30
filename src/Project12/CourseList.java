package Project12;

import java.sql.*;
import java.util.*;

import dbUtil.QueryUtil;
//This is the Business logic layer called by the interface

public class CourseList implements CourseLookUpService {

	
	//To retrieve CourseList, I am going to need userID and Password
	public Courses retrieveCourseList(String userID, String passwrod){
		
		//Create a new instance of Course bean class , so you can  access the methods
		Courses courseBean = new Courses();
		
		Map<String, List<String>> theCourses =  new HashMap<>();
		
		
		String sqlstr = "SELECT courseID, title, numOfCredits FROM Course;";
		
		//Use Try Catch so that the application does not break if database connection fails
		try {
			QueryUtil database = new QueryUtil();
			database.ConnectToDB(userID, passwrod);
			ResultSet resultset = database.getQuery(sqlstr);
		
			//NOTE: getStrings returns the value of the current column in the current row, columns starts from 1 not zero
			while(resultset.next()) {
				
				ArrayList<String> theCoursesValues = new ArrayList<String>();
						
				
				theCoursesValues.add(resultset.getString(2));
				theCoursesValues.add(resultset.getString(3));
					

				theCourses.putIfAbsent(resultset.getString(1), theCoursesValues);
								
			}
			
			courseBean.setCourseList(theCourses);
			
			resultset.close();
			database.closeConn();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(theCourses.size() > 0) {
			System.out.println("Courses Found.");
			
			//This return the courseBean instance so that when this method is called
			//after in the server we can access the courses it set into the bean method "setCourseList"
			return(courseBean); 
		}
		else {
			System.out.println("Course Not found.");
			return(null);
		}
	}
}
