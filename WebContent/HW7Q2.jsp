<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Random Background</TITLE></HEAD>
<% 
	String bgColor = request.getParameter ("bgColor");
	if ((bgColor == null)|| (bgColor.trim().equals(""))){
		bgColor = colorUtils.randomColor.getRandomColor();
	}
%>
<BODY BGCOLOR="<%=bgColor%>">
<CENTER> <!--  Headings in two colors in case bg is black.-->

<H1>User-Selected or Random Background</H1>
<H1><FONT COLOR= "WHITE">User-Selected or Random Background</FONT></H1>
<BR>
<FORM ACTION="background2.jsp" METHOD= "post">
   Color: <INPUT TYPE="TEXT" NAME= "bgColor"><BR>
<INPUT TYPE- "SUBMIT" VALUE= "Try the Color">
</FORM>
</CENTER>
</BODY>