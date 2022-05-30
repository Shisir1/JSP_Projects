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
<TABLE BORDER=5 >
	<TR>
	<TH CLASS="TITLE">
		MVC EXAMPLE: FINDING STATE ABBREVIATIONS
</TABLE>
<fieldset>
<LEGEND>Mapping US State Names to Post Office Abbreviations</LEGEND>
<!--Go to actual servelet showabbreviations  -->
<FORM ACTION="ShowAbbreviations">
	Full State Name:
	<input type="text" Name="stateName" value="${stateInfo.statName}"><br/>
	<input type="submit" value="show Abbreviation"/>
</FORM>
</fieldset>
</CENTER>

</BODY>
</HTML>