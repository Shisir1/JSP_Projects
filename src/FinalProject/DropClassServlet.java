package FinalProject;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/classDrop")
 
public class DropClassServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		   
	    ServletContext context = getServletContext();
	    
	    
	    //Check Which button was pressed
	    
	    if(request.getParameter("registerClassButton") != null) {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/classRegister");
			  dispatcher.forward(request, response);
	    }
	    else {
	    	String classId = request.getParameter("classId");
		    
		    //Get social security from servlet Context
		    String ssn = (String) context.getAttribute("ssn");
		   
		    
		    //Before calling the servlet to drop class, check if class exists, if it doesn't return error page else update classes
		    
		    if(classId == null ) {
				classId = "";
			}
		    
		    String[] courseSplit = classId.split(" ");
	    	classId = courseSplit[0];
	    	classId = classId.trim();
			
			StudentEnrollDropCourseService service = new StudentEnrollDropCourseMap();
			
			int classDeleted = service.dropClassQuery(classId, ssn);
			
			String address="";
			if(classDeleted < 1) {
				address = "/WEB-INF/results/enrollDropErrorjsp.jsp";
			}else {
				address = "/WEB-INF/results/myRegist.jsp";
			}
			
			//I'm making a requestDispatcher to the validate login servlet because that's 
			//the servlet that makes a request to get courses registered for by the currently logged in student
			//the method in login servlet takes student's social security number to find their courses
			
			//If a students tries to drop a class tehy are not registered for 
			if(classDeleted < 1) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				  dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/validateLogin");
				  dispatcher.forward(request, response);
			}
	    }
	   
		
	}
	
	

}
