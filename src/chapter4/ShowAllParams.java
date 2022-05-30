package chapter4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

//This Servlet CARES about care about reading multiple items. for example if form fields are repeated
@WebServlet ("/show-all-params")
public class ShowAllParams extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading All Request Parameters";
		String docType = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + "Transitional//EN\" >\n";
		out.println(docType + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"<TH>Parameter Name<TH>Parameter Value(s)"
				);
		Enumeration<String> paramNames = request.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			out.print("<TR><TD>" + paramName + "\n<TD>");
			String[] paramValues =
					request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<I>No Value</I>");
				else
					out.println(paramValue);
				} else {
					out.println("<UL>");
					for(int i=0; i<paramValues.length; i++) {
						out.println("<LI>" + paramValues[i]);
						}
					out.println("</UL>");
					}
			}
		out.println("</TABLE>\n</BODY></HTML>");
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException{ //TODO Auto-generated method stub 
		 doGet(request, response); 
	};
	 
}
