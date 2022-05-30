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
<TABLE BORDER=5 >
	<TR>
	<TH CLASS="TITLE">
		Log In to the Database
</TABLE>
<!--Go to actual servelet logInServlet  -->
<FORM ACTION="databaseLogin">
	User ID:
	<input type="text" Name="userID" ><br/>
	Password:
	<input type="text" Name="password" ><br/>
	<input type="submit" value="Log In To DB"/>
</FORM>
</CENTER>
</BODY>
</HTML>