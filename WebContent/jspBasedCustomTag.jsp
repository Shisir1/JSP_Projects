<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ex" tagdir ="/WEB-INF/tags"%>

<html>
   <head>
      <title>A sample custom tag</title>
   </head>
   
   <body>
   	  <br>
      <ex:myJspBasedTag foregroundColor = "ORANGE" backgroundColor="WHITE" >
      	TEST Body
      </ex:myJspBasedTag>
   </body>
</html>