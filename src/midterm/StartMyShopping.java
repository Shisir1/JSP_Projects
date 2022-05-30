package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StartMyShopping")
public final class StartMyShopping extends HttpServlet {

	private String tempHtml = "";
	private String html =
			"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
			"<title>Order Form</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<center>\r\n" + 
			"		<h1>Welcome Back</h1>\r\n" + 
			"		<form\r\n" + 
			"			action=\"ShoppingList\"\r\n" + 
			"			method=\"POST\">\r\n" + 
			"			<table border=\"1\" cellpadding=\"5\" cellspacing=\"0\">\r\n" + 
			"				<tbody>\r\n" + 
			"					<tr>\r\n" + 
			"						<td>Shopping Item:</td>\r\n" + 
			"						<td><input type=\"TEXT\" name=\"Item\" maxlength=\"20\" size=\"25\">\r\n" + 
			"						</td>\r\n" + 
			"					</tr>\r\n" + 
			"				</tbody>\r\n" + 
			"			</table>\r\n" + 
			"			<br>\r\n" + 
			"			<button type=\"SUBMIT\" name=\"AddBtn\" value=\"AddBtn\" size=\"80\">Add to Shopping List</button>\r\n" + 
			"		</form>\r\n" + 
			"	</center>\r\n" + 
			"</body>\r\n" + 
			"</html>";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		String value = request.getParameter("Item");
		 if (value != null) {
			if (value.length() == 0 || value == "") {
				html = html.replace("size=\"25\">", "size=\"25\">Please enter shopping item.");
				writer.write(html);
			} else {
				response.sendRedirect("ShoppingList");
			}
		 }
		 else
			 writer.write(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { //
		doGet(request, response);
	}	
}