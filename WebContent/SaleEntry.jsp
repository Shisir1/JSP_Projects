<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Big Number Square</TITLE>
<LINK REL=STYLESHEET
	  HREF="JSP-Styles.css"
	  TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
<TABLE BORDER=5 ALIGN="CENTER">
	<TR>
	<TH CLASS="TITLE">
		Using JavaBeans with JSP
</TABLE>
<jsp:useBean id="entry" class="chapter14.SaleEntry" />
<jsp:setProperty property="*" name="entry"/>
<%-- <jsp:setProperty
 	property="itemID" 
 	name="entry"
 	param="itemID"
/>
<jsp:setProperty
 	property="numItems" 
 	name="entry"
 	param="numItems"
/>
<jsp:setProperty
 	property="discountCode" 
 	name="entry"
 	param="discountCode"
/> --%>
<BR>
<TABLE BORDER=1>
<TR CLASS="COLORED">
	<TH>ITEM ID<TH>Unite Price<TH>Number Ordered<TH>Total Price
<TR ALIGH="RIGHT">
	<TD><jsp:getProperty property="itemID" name="entry"/>
	<TD>$<jsp:getProperty property="itemCost" name="entry"/>
	<TD><jsp:getProperty property="numItems" name="entry"/>
	<TD>$<jsp:getProperty property="totalCost" name="entry"/>
</TABLE>
</CENTER>
</BODY>
</HTML>