<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Big Number Square</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
	<TR>
	<TH CLASS="TITLE">
		Using JavaBeans with JSP
</TABLE>
<jsp:useBean id="stringBean" class="chapter14.StringBean" />
<OL>
<LI>Initial value (from jsp:getProperty):
	<I><jsp:getProperty property="message" name="stringBean"/></I>
<LI>Initial value (from JSP expression):
	<I><%= stringBean.getMessage() %></I>
<LI><jsp:getProperty
 	property="message" 
 	name="stringBean"
 	value="Best string bean: Fortex"/>
 	Value after setting property with jsp:setProperty:
 	<I><jsp:getProperty name="stringBean" property="message" /></I>
 <LI><% stringBean.setMessage("My favorite Kentucky Wonder"); %>
 	Value after setting property with scriptlet:
 	<I><%= stringBean.getMessage() %></I>
<OL>
</BODY>
</HTML>