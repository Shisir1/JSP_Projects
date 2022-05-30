package chapter8;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		for(int i = 0; i < 3; i++) {
			//Default maxAge is -1, indicating cookie
			//applies only to current browsing session.
			Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + 1);
			response.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" +i);
			// Cookie is valid for an hour, regardless of whether the user quits browser, reboots computer, or whatever.
			cookie.setMaxAge(30);
			response.addCookie(cookie);
			
		}
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		String title = "Active Cookies";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE><Hello OluwaYemisi</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN =\"CENTER\"> " + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n "+
				" <TH>Cookie Name\n" +
				" <TH>Cookie Value");
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			out.println("<TR><TH COLSPAN=2>No Coookies");
		}else {
			for(Cookie cookie: cookies) {
				out.println
				("<TR>\n" +
				" <TD>" + cookie.getName() + "\n" +
				" <TD>" + cookie.getValue());
			}
			
		}
		out.println("</TABLE></BODY></HTML>");
	};

}
