<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>Course Found</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
<h1>THE FOLLOWING COURSES WERE FOUND FOR YOU</h1>
<TABLE BORDER=1>
<TR >
	<TH>Course ID<TH>Title<TH>Course Credits</TH>
</TR>
<c:forEach var="course" items="${coursesFound}">
	<TR ALIGN="center">
		<TD>${course[0]}</TD>
		<TD>${course[1]}</TD>
		<TD>${course[2]}</TD>
	</TR>
</c:forEach>
</TABLE>
</CENTER>
</BODY>
</HTML>