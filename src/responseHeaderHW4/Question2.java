package responseHeaderHW4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;


@WebServlet("/refresh")

public class Question2 extends HttpServlet {
	
	@Override // What does this do?
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Updated Date & Time Every 5 Seconds";
		
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD>" +  title + "</HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H3>" + "Updated date is " + new Date() + "</H3>\n" +
				"</BODY></HTML>"
				);	
		
		if(true) {
			response.setHeader("Refresh", "5");
		}
	};
	
		
}
