package homeWork5;



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import coreservlets.CookieUtilities;
import java.net.*;


@WebServlet("/set-colors")
public class SetColors extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String bgColor = request.getParameter("bgColor");
		if((bgColor != null) && (!bgColor.trim().equals(""))) {
			Cookie bgColorCookie = new Cookie("bgColor", bgColor);
			bgColorCookie.setMaxAge(60*60*24*365);
			response.addCookie(bgColorCookie);
		}
		String fgColor = request.getParameter("fgColor");
		if((fgColor != null) && (!fgColor.trim().equals(""))) {
			Cookie fgColorCookie = new Cookie("fgColor", fgColor);
			response.addCookie(fgColorCookie);
		}
		response.sendRedirect("some-random-page");
	}

}
