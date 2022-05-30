<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/myJavaBasedTag.tld"%>

<html>
   <head>
      <title>A sample custom tag</title>
   </head>
   
   <body>
   	  <br>
      <ex:Color foregroundColor = "ORANGE" backgroundColor="WHITE" >
      	TEST Body
      </ex:Color>
   </body>
</html>