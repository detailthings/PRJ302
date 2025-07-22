<%-- 
    Document   : setreviewer
    Created on : Jul 21, 2025, 9:46:31 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.ProjectDAO" %>
<%@ page import="model.Project" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Reviewer" %>
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

                            <form action="SetReviewerToJuding" method="get">
                                <div class="card">
                                    <div class="card-header d-flex justify-content-between">
                                        <div class="header-title">

                                            <table >
                                                <tbody>
                                                    <tr>
                                                        <td><h4 class="card-title">Danh sách reviewer</h4></td>
                                                        <td>        ${errorMessage}     </td>
                                                        <td><input type="submit" value="Xác nhận"></td>
                                                    </tr>
                                                </tbody>
                                            </table>



                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <%
                                               List<Reviewer> listAllReviewer = (List<Reviewer>) request.getAttribute("listAllReviewer");
                                            %>




                                            <table id="datatable" class="table data-table table-striped">
                                                <thead>
                                                    <tr class="ligth">
                                                        <th>Project ID</th>
                                                        <th>Title</th>
                                                        <th>Description</th>
                                                        <th>Chấm Project</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        if(listAllReviewer == null) {
                    
                                                        } else {
                                                        for(Reviewer p : listAllReviewer) { %>
                                                    <tr>
                                                        <td> <%= p.getId() %> </td>
                                                        <td> <%= p.getReviewerID() %> </td>
                                                        <td> <%= p.getDepartment() %> </td>
                                                        <td> <input type="checkbox" name="reviewer" value="<%= p.getReviewerID() %>"> </td>

                                                    </tr>
                                                    <%  }}
                                                    %>
                                                    </tfoot>
                                            </table>



                                        </div>
                                    </div>
                                </div>

                            </form>
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
