package exerciseStatusCode;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/random")

public class Question1 extends HttpServlet {
	
	@Override // What does this do?
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		String btnClicked = request.getParameter("click_button");
		System.out.println(btnClicked + " ln 30 ");
		
		int minRange = 1;
		int maxRange = 10;
		int range = maxRange - minRange + 1;
		int randomNum = (int)(Math.random() * range) + minRange;
		int modulo = randomNum % 2;
		
		if((modulo == 0) && (btnClicked != null)) { // If random number is even
			response.sendRedirect("http://www.google.com");
		}else {
			response.sendRedirect("http://www.bing.com");
		}
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		doGet(request, response);
	};
		
}
