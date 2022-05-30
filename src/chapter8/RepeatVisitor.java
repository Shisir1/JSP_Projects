package chapter8;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;

@WebServlet("/RepeatVisitor")
public class RepeatVisitor extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c: cookies) {
				if((c.getName().equals("repeatVisitor")) && 
					(c.getValue().equals("yes"))) {
					newbie = false;
					break;
				}
			}
		}
		String title;
		if(newbie) {
			Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
			returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
			response.addCookie(returnVisitorCookie);
			title = "Welcome Aboard";
			
		}else {
			title = "Welcome Back";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE><Hello OluwaYemisi</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN =\"CENTER\"> " + title + "</H1>\n" +
				"</BODY></HTML>"
				);	
	};

}
