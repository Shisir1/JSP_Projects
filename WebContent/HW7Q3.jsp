<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>User-Specified Background</TITLE></HEAD>
<%! private String previousColor = "WHITE"; %>

<%
	String bgColor = request.getParameter("bgColor");
	if((bgColor != null) && (!bgColor.trim().equals(""))){
		previousColor = bgColor;
	}else {
		bgColor = previousColor;
	}
%>
<BODY BGCOLOR="<%=bgColor%>">
<CENTER> <!--  Headings in two colors in case bg is black.-->

<H1>User-Specific Background</H1>
<H1><FONT COLOR= "WHITE">User-Selected or Random Background</FONT></H1>
</CENTER>
</BODY>
</HTML>