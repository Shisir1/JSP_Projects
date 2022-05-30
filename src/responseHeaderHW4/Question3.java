package responseHeaderHW4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/ExportExcel")

public class Question3 extends HttpServlet {
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 response.setContentType("application/vnd.ms-excel");
		 PrintWriter out = response.getWriter();
		 
		 for( int rows = 0; rows < 10 ; rows++) {
			 for(int cols = 0; cols < 5; cols++) {
				 out.print(Math.random() + "\t");
			 }
			 out.println();
		 }
	 }
}
