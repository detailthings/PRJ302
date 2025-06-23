<%-- 
    Document   : checksession
    Created on : Jun 19, 2025, 9:52:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>-->
<%
    HttpSession ss = request.getSession(false);
    if (ss == null || ss.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>