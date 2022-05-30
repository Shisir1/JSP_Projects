package homeWork5;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import coreservlets.CookieUtilities;

import java.net.*;


@WebServlet("/registration")

public class RegistrationServelt extends HttpServlet{

	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String firstName = checkVal(request.getParameter("firstname"),
				CookieUtilities.getCookieValue(request, "firstName", null),
				"unknown last name");
		
		String lastName = checkVal(request.getParameter("lastname"),
				CookieUtilities.getCookieValue(request, "lastName", null),
				"unknown last name");
		
		String emailAddress = checkVal(request.getParameter("emailAddress"),
				CookieUtilities.getCookieValue(request, "emailAddress", null),
				"unknown email address");
		Cookie c1 = new Cookie("firstName", firstName);
		c1.setMaxAge(60*60*24*365);
		response.addCookie(c1);
				
		Cookie c2 = new Cookie("lastName", lastName);
		c2.setMaxAge(60*60*24*365);
		response.addCookie(c2);
		
		Cookie c3 = new Cookie("emailAddress", emailAddress);
		c3.setMaxAge(60*60*24*365);
		response.addCookie(c3);
		
		PrintWriter out = response.getWriter();
		String title = "Registering with Cookies";
		
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE><Hello OluwaYemisi</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN =\"CENTER\"> " + title + "</H1>\n" +
				"<UL>\n" +
				" <LI><B>First Name</B>: " +
				firstName + "\n" +
				" <LI><B>Last Name</B>: " +
				lastName + "\n" +
				" <LI><B>Email Address</B>: " +
				emailAddress + "\n" +
				"</UL>\n" +
				"</BODY></HTML>");
	}
	
	private String checkVal(String orig, String cookieVal, String replacement) {
		if((orig != null) && (!orig.equals(""))) {
			return(orig);
		}else if (cookieVal != null) {
			return(cookieVal);
		}else {
			return("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
		}
	}
	
}
