package homework1ExerciseBasics;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet ("/HelloYemisi-hw-q1")

public class ServletBasics extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE><Hello OluwaYemisi Again For Homework</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1>Hello OluwaYemisi, How are you today the 24th</H1>\n" +
				"</BODY></HTML>"
				);	
	}
	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException{ //TODO Auto-generated method
	 * stub doGet(request, response); }
	 */
}