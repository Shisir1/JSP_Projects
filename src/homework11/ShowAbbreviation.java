package homework11;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/ShowAbbreviations")

//MVC
 //- get parameter from user
//- create the business layer object that returns the interface
//- call interface method pass in request parameter which returns bean class
//- store bean class return into request.setAttribute
//-based on the bean class decide which page you want to go


public class ShowAbbreviation extends HttpServlet {
	
	private StateAbbreviationService abbreviationMapper = new StateAbbreviationMapper();
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  String stateName = request.getParameter("stateName");
	
	  
	  if(stateName == null) {
		  stateName = "";
	  }
	  stateName = stateName.trim();
	  
	  //This calls the interface class, and the interface class calls the business logic layer class
	  //that returns data into a bean object
	  String stateAbbreviation = abbreviationMapper.findAbbreviation(stateName);
	  
	  //Create statePairBean aka a class
	  StatePair stateInfo = new StatePair(stateName, stateAbbreviation);
	  HttpSession session = request.getSession();
//	  request.setAttribute("stateInfo", stateInfo);
	  
	  session.setAttribute("stateInfo", stateInfo);
	  String address;
	  if(stateName.isEmpty()) {
		  address = "/WEB-INF/results/missingState.jsp";
	  }
	  else if(stateAbbreviation != null) {
		  address = "/WEB-INF/results/showAbbreviation.jsp";
	  }
	  else {
		  address = "/WEB-INF/results/unknownState.jsp";
	  }
	  RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	  dispatcher.forward(request, response);
  }
}