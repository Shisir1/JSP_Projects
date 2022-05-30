<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Login To See Courses</TITLE>
<LINK REL=STYLESHEET
	  HREF="./FinalProjectJSPS/JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
<TABLE id="headerTable">
	<TR>
		<TH>Name:<TH> Student FullName<TH> Phone #:<TH> Student Phone #
	</TR>
	<TR id="headerRow">
		<TD> </TD>
		<TD>${studentFound.fname} ${studentFound.lname}</TD>
		<TD> </TD>
		<TD>${studentFound.phone}</TD>
	</TR>
</TABLE>
<!--Go to enroll.jsp or registLogin  -->
<h3>My Classes</h3>
<div>
<TABLE BORDER=1>
<TR >
	<TH>Course ID<TH>Title<TH>Grade</TH>
</TR>
<c:forEach var="course" items="${studentsCoursesFound}">
	<TR ALIGN="center">
		<TD>${course.courseID}</TD>
		<TD>${course.title}</TD>
		<TD>${course.grade}</TD>
	</TR>
</c:forEach>
</TABLE>

<div id="mainPageButtons">
	<a href="./FinalProjectJSPS/registLogin.jsp"><button>Exit</button></a>
	<a href="./FinalProjectJSPS/enroll.jsp"><button name="enrollButton">Enroll</button></a>
</div>

</CENTER>
</BODY>
</HTML>