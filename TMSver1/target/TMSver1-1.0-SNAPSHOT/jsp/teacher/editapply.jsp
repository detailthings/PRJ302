<%-- 
    Document   : deliverable
    Created on : Jun 18, 2025, 4:42:57 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Webkit | Responsive Bootstrap 4 Admin Dashboard Template</title>

        <%@include file="/jsp/common/layout/favicon.jsp" %>  </head>
    <body class="  ">
        <!-- check session -->
        <%@include file="/jsp/common/layout/checksession.jsp" %>
        <!-- loader Start -->
        <div id="loading">
            <div id="loading-center">
            </div>
        </div>
        <!-- loader END -->
        <!-- Wrapper Start -->
        <div class="wrapper">

            <%@include file="/jsp/common/layout/slidebarteacher.jsp" %>     
            <div class="iq-top-navbar">
                <%@include file="/jsp/common/layout/navteacher.jsp" %>  
            </div>      
            <div class="content-page">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="${path}/editapplycontroller" method="post">
                                <% 
                                    Request editApply = (Request) request.getAttribute("editApply");
                                %>
                                <input type="hidden" name="id" value="<%=editApply.getId()%>">
                                <input type="hidden" name="studentID" value="<%=editApply.getStudentID()%>">
                                <input type="hidden" name="teacherID" value="$<%=editApply.getTeacherID()%>">
                                <input type="hidden" name="status" value="None">
                                <input type="hidden" name="createAt" value="<%=editApply.getCreateAt()%>">
                                <div class="form-group">
                                    <label for="title">Title:</label>
                                    <input type="text" class="form-control" id="title" name="title" maxlength="255" required pattern="^[A-Za-zÀ-Ỹà-ỹ\s]+$" value="<%=editApply.getTitle()%>">
                                </div>
                                <div class="form-group">
                                    <label for="description">Description:</label>
                                    <input type="text" class="form-control" id="title" name="description" maxlength="255" required value="<%=editApply.getDescription()%>">
                                </div>
                                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                <button type="reset" class="btn iq-bg-danger">Cancel</button>
                            </form>
                            <!-- Page end  -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Wrapper End-->

        <!-- Modal list start -->
        <%@include file="/jsp/common/layout/footer.jsp" %>
        <%@include file="/jsp/common/layout/js.jsp" %>
    </body>
</html>




