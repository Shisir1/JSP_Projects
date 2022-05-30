package FinalProject;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import finalProjectBean.ClassesBean;
import finalProjectBean.EnrollBean;
import finalProjectBean.StudentBean;

import java.util.*;

@WebServlet("/validateLogin")

public class ValidateLoginServlet extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
	    
		String ssn = request.getParameter("ssn");
		
		ArrayList<EnrollBean> studentsCourses;
		
		
		String retrievedSSN  = (String) context.getAttribute("ssn");
		
		//Cookie to store student info found through the studentBean
		Cookie activeStudent;
		
		
		StudentBean foundStudent = (StudentBean) context.getAttribute("studentFound");
		
		String address="";
		
		if(ssn == null ) {
			ssn = "";
		}
		ssn = ssn.trim();

		  
		StudentLoginService service = new StudentLoginMap();  
		
		EnrolledCoursesLookupService  service2 = new EnrolledCoursesMap();
		  
		StudentEnrollDropCourseService service3 = new StudentEnrollDropCourseMap();
		  
		
		
		/*Since this servlet takes student social security to find courses student is enrolled in
		I am going to check if the application context has the social security saved 
		and based on that make a call to retrieve students courses
		Doing this so that when student's drops and add classes, their social is availbe to be used
			*/	
		
		if(retrievedSSN  == null) {
			//this is the first time they are logging in

			foundStudent = service.findStudent(ssn);
			studentsCourses = service2.retrieveStudentCourses(ssn);
			
			/*Set context here because this is the first time student is login in
			Set context only if found student is not null, which means the student is in the database,
			so I don't store a social for a student not in the database
			*/
			if(foundStudent != null) {
				context.setAttribute("ssn", ssn);
				context.setAttribute("studentFound", foundStudent);		
			}
			
			
		}
		else {
			//they have been active 
			studentsCourses = service2.retrieveStudentCourses(retrievedSSN);
		}
		
		ArrayList<ClassesBean> allCourses = service3.allClassesAvailable();
		
		//if foundstudent of type student bean called from the business layer logic is null, i.e if the business layer logic, the databse didn't find any student
		if(foundStudent == null && retrievedSSN == null) {
			request.setAttribute("studentFound", "");
		}
		else {
			request.setAttribute("studentFound", foundStudent);
			request.setAttribute("studentsCoursesFound", studentsCourses);
			context.setAttribute("allCourses", allCourses);
		}
		if(foundStudent == null && retrievedSSN == null) {
			//Go to login error page
			address = "/WEB-INF/results/loginError.jsp";
		}
		else {
			address = "/WEB-INF/results/myRegist.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
	}

}
