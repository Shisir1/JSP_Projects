package homeWork5;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/page-two")


public class PageTwo extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		boolean hasVistedPageOne = false;
		Cookie[] cookiesFound = request.getCookies();
		
		if(cookiesFound != null) {
			for(Cookie c: cookiesFound) {
				if((c.getName().equals("visitedPageOne")) &&
						(c.getValue().equals("yes"))) {
					hasVistedPageOne = true;
					break;
				}
			}
		}
		if(hasVistedPageOne) {
			response.sendRedirect("page-one");
		}else {
			String title = "Page Two";
			response.setContentType("text/html");
			PrintWriter  out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\" >\n";
			out.println(docType + 
					"<HTML>\n" +
					"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<H1 ALIGN =\"CENTER\"> " + title + "</H1>\n" );
		}
	}

}
