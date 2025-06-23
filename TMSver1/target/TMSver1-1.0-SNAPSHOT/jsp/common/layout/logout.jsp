<%-- 
    Document   : logout
    Created on : Jun 19, 2025, 10:47:58 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Lấy session hiện tại, không tạo mới
            HttpSession ss = request.getSession(false);
            ss.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
