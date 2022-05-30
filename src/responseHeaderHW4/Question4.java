package responseHeaderHW4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/delayed-redirection")

public class Question4 extends HttpServlet{

	@Override // What does this do?
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		response.setContentType("text/html");
		String url;
		
		String userAgent = request.getHeader("User-Agent");
		if((userAgent != null) && (userAgent.contains("MSIE"))){
			url = " http://www.microsoft.com";
		}else {
			url = "http://www.mozilla.org";
		}
		response.setHeader("Refresh", "10; URL=" + url);
		PrintWriter out = response.getWriter();
	}
	

}
