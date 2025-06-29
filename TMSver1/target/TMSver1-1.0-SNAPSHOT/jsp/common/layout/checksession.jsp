<%
    HttpSession ss = request.getSession(false);
    if (ss == null || ss.getAttribute("user") == null) {
        response.sendRedirect("../common/layout/login.jsp");
        return;
    }
%>
