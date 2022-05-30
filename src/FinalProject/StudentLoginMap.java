package FinalProject;


import java.sql.*;
import java.util.*;

//import Project12.Courses;
//import dbUtil.QueryUtil;
import dbUtil.StudentQueryUtil;
import finalProjectBean.StudentBean;


//This is the Business logic layer for looking up student called by the interface
public class StudentLoginMap implements StudentLoginService {

	
	//Write a Query to look up the student
	public StudentBean findStudent(String ssn) {
		
		ArrayList<String> studentDetails= new ArrayList<String>();
		
		ArrayList<List> studentArr = new ArrayList<List>();
				
		String getStudent = "SELECT * FROM Students WHERE ssn=" + ssn;
		
		
		try {
			StudentQueryUtil database = new StudentQueryUtil();
			
			database.ConnectToDB();
			ResultSet studentFound = database.findStudentQuery(getStudent);
			
			
			//Check if resultset has data returned, since it's only 1 data, you can use if statement
			while(studentFound.next()) {
				
				studentDetails.add(studentFound.getString("ssn"));
				studentDetails.add(studentFound.getString("firstName"));
				studentDetails.add(	studentFound.getString("mi"));
				studentDetails.add(	studentFound.getString("lastName"));
				studentDetails.add(	studentFound.getString("birthDate"));
				studentDetails.add(	studentFound.getString("street"));
				studentDetails.add(	studentFound.getString("phone"));
				studentDetails.add(	studentFound.getString("zipcode"));
				studentDetails.add(	studentFound.getString("deptId"));
				
				studentArr.add(studentDetails);
				
			}
		
			studentFound.close();
			database.closeConn();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(studentArr.size() > 0) {
			System.out.println("Student Found. ");
			
			//Create a new instance of Student bean class , so you can  access the methods
			StudentBean studentBean = new StudentBean(
					studentDetails.get(0),
					studentDetails.get(1),
					studentDetails.get(2),
					studentDetails.get(3),
					studentDetails.get(4),
					studentDetails.get(5),
					studentDetails.get(6),
					studentDetails.get(7),
					studentDetails.get(8)
				);
			
			return (studentBean);
		}
		else {
			System.out.println("Student Not found.");
			return(null);
		}
		
	}

}
