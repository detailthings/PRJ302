<%-- 
    Document   : myproject
    Created on : Jun 18, 2025, 4:46:02 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Webkit | Responsive Bootstrap 4 Admin Dashboard Template</title>

        <%@include file="/jsp/common/layout/favicon.jsp" %>   </head>
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

            <%@include file="/jsp/common/layout/slidebaradmin.jsp" %>
            <%@include file="/jsp/common/layout/navadmin.jsp" %>     
            <div class="content-page">
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
                                           List<Deliverable> listAllDeliverable = (List<Deliverable>) request.getAttribute("listAllDeliverable");
                                        %>
                                        <table id="datatable" class="table data-table table-striped">
                                            <thead>
                                                <tr class="ligth">
                                                    <th>Deliverable ID</th>
                                                    <th>Title</th>
                                                    <th>Description</th>
                                                    <th>Weighting</th>
                                                    <th>Submission Open Date</th>
                                                    <th>Due Date</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    if(listAllDeliverable == null) {
                    
                                                    } else {
                                                    for(Deliverable p : listAllDeliverable) { %>
                                                <tr>
                                                    <td> <%= p.getDeliverableID() %> </td>
                                                    <td> <%= p.getTitle() %> </td>
                                                    <td> <%= p.getDescription() %> </td>
                                                    <td> <%= p.getWeighting() %> </td>
                                                    <td> <%= p.getSubmissionOpenDate() %> </td>
                                                    <td> <%= p.getDueDate() %> </td>
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
