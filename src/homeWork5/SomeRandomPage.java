package homeWork5;



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import coreservlets.CookieUtilities;
import java.net.*;

@WebServlet("/some-random-page")

public class SomeRandomPage extends HttpServlet{
	
	@Override

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String bgColor = CookieUtilities.getCookieValue(request," bgColor", "WHITE");
		String fgColor =
				CookieUtilities.getCookieValue(request, "fgColor", "BLACK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Some Random Page";
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
				"<BODY BGCOLOR=\"" + bgColor +
				"\" TEXT=\"" + fgColor + "\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
				"Somthing very very extremely ridicoulousely random\n" +
				"See the <A HREF=\"color-setup.html\">\n" +
				"color setup page</A> to\n" +
				"customize the colors on this page.\n" +
				"</Body></HTML"
				);
	}

}
