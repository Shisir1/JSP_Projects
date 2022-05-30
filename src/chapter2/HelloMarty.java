package chapter2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import coreservlets.ServletUtilities;


@WebServlet ("/Hi-Yemisi")
public class HelloMarty extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		String docType = 
//				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(ServletUtilities.headWithTitle("Hello Oluwayemisi") + 
//				"<HTML>\n" +
//				"<HEAD><TITLE><Hello OluwaYemisi</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1>Hello OluwaYemisi, How are you today</H1>\n" +
				"</BODY>" + ServletUtilities.footer()
				+"</HTML>");	
	}
	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException{ //TODO Auto-generated method
	 * stub doGet(request, response); }
	 */
	
}