<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Database Log In</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
<h2 id="welcome">Welcome! Please Log In To See Your Classes</h2>
<!--Go to actual servelet validateLogin, if invalid redirect to login error page from the servlet -->
<FORM ACTION="../validateLogin" id="loginForm">

	SSN:
	<input type="text" Name="ssn" >

	<input type="submit" value="Log In"/>
</FORM>
</BODY>
</HTML>