<%-- 
    Document   : myproject
    Created on : Jun 18, 2025, 4:46:02 PM
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
    <body class=" color-light ">
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
            </div>      <div class="content-page">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card">
                                <div class="card-header d-flex justify-content-between">
                                    <div class="header-title">
                                        <h4 class="card-title">Datatables</h4>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <%
                                           List<Project> listProject = (List<Project>) request.getAttribute("listProject");
                                        %>
                                        <table id="datatable" class="table data-table table-striped">
                                            <thead>
                                                <tr class="ligth">
                                                    <th>Project ID</th>
                                                    <th>Title</th>
                                                    <th>Description</th>
                                                    <th>Teacher</th>
                                                    <th>Semester</th>
                                                    <th>Jubging</th>
                                                    <th>Members</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    if(listProject == null) {
                    
                                                    } else {
                                                    for(Project p : listProject) { %>
                                                <tr>
                                                    <td> <%= p.getProjectCode() %> </td>
                                                    <td> <%= p.getTitle() %> </td>
                                                    <td> <%= p.getDescription() %> </td>
                                                    <td> <%= p.getTeacherID() %> </td>
                                                    <td> <%= p.getSemesterID() %> </td>
                                                    <td> <%= p.getJudgingID() %> </td>
                                                    <td> <%= p.getStudentID() %> </td>
                                                </tr>
                                                <%  }}
                                                %>
                                                </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
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
