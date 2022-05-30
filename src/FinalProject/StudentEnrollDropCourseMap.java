package FinalProject;


import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import dbUtil.StudentQueryUtil;
import finalProjectBean.ClassesBean;
import finalProjectBean.EnrollBean;

//This is the Business logic layer for dropping and adding classes called by the interface

public class StudentEnrollDropCourseMap implements StudentEnrollDropCourseService {
	
	
	//NOTE: Call the "allClassesAvailable" service inside validateLogin servlet because the courses should already 
	//be available in the drop down once students presses login and they are validated
	
	
	public ArrayList<ClassesBean> allClassesAvailable() {
		
		Map<String, String> availableCourses =  new HashMap<>();
		
		ArrayList<ClassesBean>  listOfAvailableCourses = new ArrayList<ClassesBean>();
		
		String allCoursesQuery = "SELECT courseID, title FROM Course;";
		
		try {
			StudentQueryUtil database = new StudentQueryUtil();
			
			StudentQueryUtil.ConnectToDB();
			ResultSet resultset = database.findAllCourses(allCoursesQuery);
		
			//NOTE: getStrings returns the value of the current column in the current row, columns starts from 1 not zero
			while(resultset.next()) {
											
				availableCourses.putIfAbsent(resultset.getString(1), resultset.getString(2));
								
			}
			
			resultset.close();
			database.closeConn();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		if(availableCourses.size()> 0) {
			
			System.out.println("Courses Found.");
			
			for(Entry<String, String> course: availableCourses.entrySet()) {
				
				ClassesBean newClass = new ClassesBean(
						course.getKey(),
						course.getValue()
						);
				
				listOfAvailableCourses.add(newClass);
				
			}
			return (listOfAvailableCourses);
			
		}
		else {
			System.out.println("Courses Not found.");
			return(null);
		}
	}
	
	
	public int dropClassQuery(String courseID, String ssn) {
		
		//check if course is currently registered before deleting,
		//If it is registred , delete it and re route server to myRegit.jsp 
		//if not , return null
		
		int deleted;
		
		ArrayList<EnrollBean> courses = new EnrolledCoursesMap().retrieveStudentCourses(ssn);

		String deletCourseQuery ="DELETE FROM Enrollment WHERE ssn=" + ssn + " AND courseId= " + "'"+courseID + "'";
		
		if(courses == null) {
			return 0;
		}
		else {
			for(EnrollBean course: courses) {
				
				String courseid = course.getCourseID();
						
				if(courseid.equals( courseID)){
					try {
						StudentQueryUtil database = new StudentQueryUtil();
						
						StudentQueryUtil.ConnectToDB();
						deleted = database.dropClassQuery(deletCourseQuery);
					
						
						database.closeConn();
						
						System.out.println("successfully deleted " + deleted);
						return deleted;
					}
					catch(ClassNotFoundException | SQLException e) {
						e.printStackTrace();
						System.out.println(e);
					}
					
				}
				
			}
		}
		
		System.out.println("Course might not be registered in the database");
		return 0;
	}
	
	public int addClassQuery(String courseID, String grade, String ssn) {
		
		ArrayList<EnrollBean> courses = new EnrolledCoursesMap().retrieveStudentCourses(ssn);
		
		LocalDate date = java.time.LocalDate.now();
		
		System.out.println(date);
		
		int inserted;
		
		System.out.println("I got courses in add class " + courses);
		
		String insertCourseQuery = "INSERT INTO Enrollment VALUES(" + "'"+ ssn +"'" + " , " + "'" + courseID +"'" + " , " + "'"+ date +"'" + " , " + "'" + grade +"'" + ")";
		
		//Check if the student is already registered/enrolled for that course
		//if they are enrolled, return error page, if not insert the course into database
		if(courses == null) {
			try {
				StudentQueryUtil database = new StudentQueryUtil();
				
				StudentQueryUtil.ConnectToDB();
				inserted = database.dropClassQuery(insertCourseQuery);
			
				
				database.closeConn();
				
				System.out.println("successfully inserted " + inserted);
				return inserted;
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		else {
			for(EnrollBean course: courses) {
				
				String courseid = course.getCourseID();
				
				if(courseid.equals(courseID)) {
					
					System.out.println("You are currently registered for this class");
					return 0;
				}
				else {
					try {
						StudentQueryUtil database = new StudentQueryUtil();
						
						StudentQueryUtil.ConnectToDB();
						inserted = database.dropClassQuery(insertCourseQuery);
					
						
						database.closeConn();
						
						System.out.println("successfully inserted " + inserted);
						return inserted;
					}
					catch(ClassNotFoundException | SQLException e) {
						e.printStackTrace();
						System.out.println(e);
					}
				}
			}
		
		}
		return 1;
	}

}
