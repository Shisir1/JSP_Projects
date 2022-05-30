package exerciseStatusCode;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/10threquest")

public class Question3 extends HttpServlet {
	
	int clickCount = 0;
	@Override // What does this do?
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		String btnClicked = request.getParameter("click_button");		
	
		while(btnClicked != null) {
			System.out.println("btn is clicked");
			clickCount += 1;

		
			if(clickCount % 10 == 0) {
				response.sendRedirect("http://nytimes.com");
			}else {
				response.sendRedirect("http://washingtonpost.com");
			}
			btnClicked = null;
		}
		
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		doGet(request, response);
	};
		
}
