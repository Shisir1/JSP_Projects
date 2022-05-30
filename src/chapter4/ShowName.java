package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

//This servlet doesn't care about reading multiple items. for example if form fields are repeated
@WebServlet ("/showname")
public class ShowName extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading Name";
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<UL>\n" +
				" <LI><B>First Name</B>: "
				+ request.getParameter("firstname") + "\n" +
				" <LI><B>Last name</B>: "
				+ request.getParameter("lastname") + "\n" +
				" <LI><B>Email</B>: "
				+ request.getParameter("email") + "\n" +
				"</UL>\n" +
				"</BODY></HTML>"
				);	
	}
	

	 protected void doPost(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		 doGet(request, response); 
	};
	 
}
