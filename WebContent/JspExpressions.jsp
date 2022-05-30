<!DOCTYPE HTML PUBLIC *-//W3C/ /DTD HTML 4.8 Transitional//EN">
<HTML>
<HEAD>
<TITLE>JSP Expressions</TITLE>
<META NAME = "keywords"
	CONTENT= "SP, expressions, JavaServer Pages, servlets">
<META NAME= "description"
	CONTENT-*A quick example of JSP expressions.">
<LINK REL=STYLESHEET
	HREF="JSP-StyLes.css"
	TYPE="text/css">
</HEAD>
<BODY>
<H2>JSP Expressions</H2>
<UL>
	<LI>Current time: <%= new java.util.Date() %>
	<LI>Server: <%= application.getServerInfo() %>
	<LI>Session ID: <%= session.getId() %>
	<LI>The <CODE>testParam</CODE> form parameter:
		<%= request.getParameter("testParam")%>
</UL>
</BODY>
</HTML>