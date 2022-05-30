<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Big Number Square</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/cc">
</HEAD>
<BODY>
<H1>Squaring Big Numbers</H1>
<%@ page import="java.math.*" %>
<% String baseNumber = request.getParameter("baseNumber");
	BigInteger initial;
	try {
		initial = new BigInteger(baseNumber);
	}catch(Exception e){
		initial = new BigInteger("23487680986");
	}
	BigInteger result = initial.pow(2);
%>
<H3>The Square of <%= initial %> is <%= result %></H3>
</BODY>
</HTML>