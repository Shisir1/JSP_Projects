package Project12;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/databaseLogin")

//MVC
 //- get parameter from user
//- create the business layer object that returns the interface
//- call interface method pass in request parameter which returns bean class
//- store bean class return into request.setAttribute
//-based on the bean class decide which page you want to go


public class LoginServlet extends HttpServlet {
	
//	private StateAbbreviationService abbreviationMapper = new StateAbbreviationMapper();
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  String userID = request.getParameter("userID");
	  String password = request.getParameter("password");
	  
	  if(userID == null || password == null) {
		  userID = "";
		  password = "";
	  }
	  userID = userID.trim();
	  password = password.trim();
	  
	  CourseLookUpService service = new CourseList();
	  
	  //An instance of the bean class
	  Courses coursesRetrieved = service.retrieveCourseList(userID, password);

	  
	  if(coursesRetrieved == null) {
		  request.setAttribute("coursesFound", "");
	  }else {
		  
		  request.setAttribute("coursesFound", coursesRetrieved.getCourseList());
	  }
	  
	  String address="";
	  if(coursesRetrieved == null) {
		  address = "/WEB-INF/results/NoCourseFound.jsp";
	  }
	  else {
		  address = "/WEB-INF/results/courseResults.jsp";
	  }
	  RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	  dispatcher.forward(request, response);
  }
}