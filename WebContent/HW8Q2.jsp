<% int rows = 1 + (int)(Math.random() * 20);
	int cols = 3;
	for(int i =1; i <= rows; i++){
		for(int j= 1; j < cols; j++){
			out.print("Row "+ i + ", Col " + j + "\t");
		}
		out.println();
	}

%>

<%@ page contentType="application/vnd.ms-excel" %>