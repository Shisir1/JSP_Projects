package homework1ExerciseBasics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/tables")

public class Tables extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int i = 25;
		int j = 10;
		
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
				out.println(docType + 	
						"<HTML>\n" +
						"<HEAD><TITLE><Hello OluwaYemisi Again For Homework</TITLE></HEAD>\n" +
						"<BODY BGCOLOR=\"#FDF5E6\">\n" +
						"<table BORDER=\"#5px Solid Black\">\n" +
						"<tr BORDER=\"#5px Solid Black\">\n" +
						"<td BORDER=\"#5px Solid Black\">\n"+
						"</td>" +
						"</tr>"+
						"</table>" +
						"</BODY>"
						+ "</HTML>"
				);
	}
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException{ //TODO Auto-generated method
	 * stub doGet(request, response); }
	 */
}
