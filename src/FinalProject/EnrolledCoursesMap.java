package FinalProject;


import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import dbUtil.StudentQueryUtil;

//This is the Business logic layer called by the interface
import finalProjectBean.EnrollBean;

//This is the Business logic layer for finding already enrolled courses for students called by the interface EnrolledCoursesLookupService 
public class EnrolledCoursesMap implements EnrolledCoursesLookupService {

	//Write a Query to find the students courses based on their social security number
	public ArrayList<EnrollBean> retrieveStudentCourses(String ssn) {
		
		Map<String, List<String>> theCourses =  new HashMap<>();
		
		String getStudentRegisteredCourses = " SELECT Enrollment.courseId, Enrollment.grade, Course.title\n"
				+ "FROM Enrollment, Course\n"
				+ "WHERE Enrollment.courseId = Course.courseID\n"
				+ "AND Enrollment.ssn=" + ssn;
		

		//Use Try Catch so that the application does not break if database connection fails
		try {
			StudentQueryUtil database = new StudentQueryUtil();
			
			StudentQueryUtil.ConnectToDB();
			ResultSet coursesFound = database.findStudentCoursesQuery(getStudentRegisteredCourses);
	
			
			while(coursesFound.next()) {
				
				ArrayList<String> theCoursesValues = new ArrayList<String>();
				
				theCoursesValues.add(coursesFound.getString(2));
				theCoursesValues.add(coursesFound.getString(3));
				
				theCourses.putIfAbsent(coursesFound.getString(1), theCoursesValues);

				
			}
			
			coursesFound.close();
			database.closeConn();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(theCourses.size()> 0) {
			
			System.out.println("Courses Found.");
			
			ArrayList<EnrollBean>  enrolledCoursesBeans = new ArrayList<EnrollBean>();
			
			for(Entry<String, List<String>> course: theCourses.entrySet()) {
				
				//save the grade and course title stored as arrays in a variable
				
		
				String courseID = (String) course.getKey();
				
				//save the grade and course title stored as arrays in a variable
				List<String> gradeAndTitle = course.getValue();
				
				EnrollBean courseBean = new EnrollBean(
						courseID,
						gradeAndTitle.get(1),
					    gradeAndTitle.get(0)
						);
				enrolledCoursesBeans.add(courseBean);
			}
			return (enrolledCoursesBeans);
			
		}
		else {
			System.out.println("Courses Not found.");
			return(null);
		}
	}

}
