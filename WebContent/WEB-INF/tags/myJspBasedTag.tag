<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name = "foregroundColor" %>
<%@ attribute name = "backgroundColor" %>

<p style ="color: ${foregroundColor}; background-Color: ${backgroundColor};">
<jsp:doBody/>
<p/>