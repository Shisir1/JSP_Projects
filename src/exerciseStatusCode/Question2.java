package exerciseStatusCode;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/error")

public class Question2 extends HttpServlet {
	
	@Override // What does this do?
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Favorite Language";
		String favLanguage = request.getParameter("favorite_language");
	
		
		if(favLanguage.equals("java")){
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
			out.println(docType + 
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
					"<H2 ALIGN=CENTER>" + " Your favorite language is " + favLanguage + "</H2>\n" 
					);
		}else {
			System.out.println(favLanguage + " ln 24");
			errorMessage(response, "unsupported Favorite Language");
		}
		
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		doGet(request, response);
	};
	
	private void errorMessage(HttpServletResponse response,
			String message)
			throws IOException {
			response.sendError(response.SC_NOT_FOUND, message );
	}
		
}

