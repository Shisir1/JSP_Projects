package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wrongbrowser")

public class CyberShopping extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ //TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String url = "https://www.microsoft.com/en-us/";
		
		String userAgent = request.getHeader("User-Agent");
		
		PrintWriter out = response.getWriter();
		
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		String title;
		
		
		if((userAgent != null) && (userAgent.contains("IE"))){
			errorMessage(response, "Only IE browser is working for this site. In 5 seconds, you will be redirected to microsoft.com site");	
			response.setHeader("Refresh", "5; URL=" + url);
			//SOLVE question 1, part2
			System.out.println("Right browser");
			
		}else {
			if(cookies != null) {
				for(Cookie c: cookies) {
					if((c.getName().equals("repeatVisitor")) && 
						(c.getValue().equals("yes"))) {
						newbie = false;
						break;
					}
				}
			}
			if(newbie) {
				Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
				returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
				response.addCookie(returnVisitorCookie);
				title = "Welcome";
				String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
				out.println(docType + 
						"<BODY BGCOLOR=\"#FDF5E6\">\n" +
						"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
						"<a href=\"http://localhost/Spring22/StartMyShopping\">Start Shopping</a>\n" 
						);
				out.println("<A HREF='StartMyShopping'>Start Shopping</A>");
			}else {
				response.sendRedirect("StartMyShopping");
			}
			
//			solve question 1, part 1
//			errorMessage(response, "Only IE browser is working for this site. In 5 seconds, you will be redirected to microsoft.com site");	
		}
		

		
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		doGet(request, response);
	};
	
	private void errorMessage(HttpServletResponse response,
			String message)
			throws IOException {
			response.sendError(response.SC_HTTP_VERSION_NOT_SUPPORTED, message );
	}
	
		
}
