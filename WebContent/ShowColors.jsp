<!DOCTYPE HTML PUBLIC "-//N3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<!-- Note, to remeber what users typed in before when using beans, just add scope = session -->
<TITLE>Show Colors</TITLE>
<jsp:useBean id="colorBean1" class="chapter14.ColorBean" />
<BODY BGCOLOR="<jsp:getProperty
				name="colorBean1"
				property="backgroundColor" scope="session"/>" 
		TEXT="<jsp.getProperty
				name="colorBean1"
				property="foregroundColor"/>">
<H1>Show Colors (1)</H1>
Blah Blah Blah Blah
</BODY>
</HTML>
