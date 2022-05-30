<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Class Enrollment</TITLE>

<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY >
<H2 id="enrollHeader">SELECT A COURSE AND A GRADE BELOW TO ENROLL</H2>
<div id="enrollForm">
	<FORM ACTION="../classDrop">
		<DIV class="flexDiv">
			<LABEL for="course">Courses:</LABEL>
			<SELECT name="classId" id="course">
				<c:forEach var="thecourse" items="${allCourses}">
					<option>${thecourse.courseID} - ${thecourse.title}</option>
				</c:forEach>
			</SELECT>
		</DIV>
		<DIV class="flexDiv">
			<LABEL for="grade">Grade:</LABEL>
			<SELECT name="grades" id="grade">
				<option value="A">A</option>
				<option value="A-">A-</option>
				<option value="B">B</option>
				<option value="B+">B+</option>
				<option value="B-">B-</option>
		 		<option value="C">C</option>
				<option value="C+">C+</option>
				<option value="C-">C-</option>
				<option value="D">D</option>
				<option value="E">E</option>
				<option value="F">F</option>
			</SELECT>
		</DIV>
		
		<DIV id="buttonDivs">
			<input type="submit" value="Drop" name="dropclassButton"/>
			<input type="submit" value="Register" name="registerClassButton"/>
		</DIV>
	</FORM>
	<a href="../validateLogin" id="exitButton"><button>Exit</button></a>
</div>
</BODY>
</HTML>