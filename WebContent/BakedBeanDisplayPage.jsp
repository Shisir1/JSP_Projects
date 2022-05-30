<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Baked Bean Values: Page-based sharing</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<H1>Baked Bean Value: page-based Sharing</H1>
<jsp:useBean id="pageBean" class="chapter14.BakedBean" />
<jsp:setProperty property="*" name="pageBean"/>
<H2>Bean Level:
<jsp:getProperty name="pageBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty property="goesWith" name="pageBean"/>
</BODY>
</HTML>