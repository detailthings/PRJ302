<%-- 
    Document   : deliverable
    Created on : Jun 18, 2025, 4:42:57 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Webkit | Responsive Bootstrap 4 Admin Dashboard Template</title>

        <%@include file="/jsp/common/layout/favicon.jsp" %>   </head>
    <body class="  ">
        <!-- check session -->
        <%@include file="/jsp/common/layout/checksession.jsp" %> 
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
                        <div class="col-12">
                            <div class="card-transparent card-block card-stretch card-height">
                                <div class="card-body p-0">
                                    <div class="card">
                                        <div class="card-header d-flex justify-content-between">
                                            <div class="header-title">
                                                <h4 class="card-title">Overview</h4>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <ul class="list-inline p-0 mb-0">
                                                <li class="mb-1">
                                                    <div class="row align-items-center">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Number of project</p>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="d-flex align-items-center justify-content-between">
                                                                <div class="iq-progress-bar bg-primary-light">
                                                                    <span class="bg-primary iq-progress progress-1" data-percent="100" style="width: 100%;"></span>
                                                                </div>
                                                                <span class="ml-3">100%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="mb-1">
                                                    <div class="row align-items-center">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Number of project in this semester</p>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="d-flex align-items-center justify-content-between">
                                                                <div class="iq-progress-bar bg-primary-light">
                                                                    <span class="bg-primary iq-progress progress-1" data-percent="15" style="width: 15%;"></span>
                                                                </div>
                                                                <span class="ml-3">15%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="mb-1">
                                                    <div class="row align-items-center">
                                                        <div class="col-sm-3">
                                                            <p class="mb-0">Scorce >= 8.0</p>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="d-flex align-items-center justify-content-between">
                                                                <div class="iq-progress-bar bg-primary-light">
                                                                    <span class="bg-primary iq-progress progress-1" data-percent="60" style="width: 60%;"></span>
                                                                </div>
                                                                <span class="ml-3">60%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Page end  -->
                </div>
            </div>
        </div>
        <!-- Wrapper End-->

        <!-- Modal list start -->
        <%@include file="/jsp/common/layout/footer.jsp" %> 
        <%@include file="/jsp/common/layout/js.jsp" %> 
</html>