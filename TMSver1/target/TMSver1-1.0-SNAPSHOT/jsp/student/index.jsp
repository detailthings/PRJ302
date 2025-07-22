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

        <%@include file="/jsp/common/layout/favicon.jsp" %>
    </head>
    <body class="  ">
        <!-- check session && loader Start -->
        <%@include file="/jsp/common/layout/checksession.jsp" %>
        <!-- loader Start -->
        <div id="loading">
            <div id="loading-center">
            </div>
        </div>
        <!-- loader END -->
        <!-- Wrapper Start -->
        <div class="wrapper">

            <%@include file="/jsp/common/layout/slidebarstudent.jsp" %>
            <%@include file="/jsp/common/layout/navstudent.jsp" %>       <div class="content-page">
                <div class="container-fluid">
                    <div>
                        <h4>HELLO ${useraccount.fullName}_${studentProfile.studentCode},</h4></br>
                    </div>
                    <div class="row">
                        <div class="col-xl-8">
                            <div class="card-transparent card-block card-stretch card-height">
                                <div class="card-body p-0">
                                    <div class="card">
                                        <div class="card-header d-flex justify-content-between">
                                            <div class="header-title">
                                                ${notionNotHaveProject!=null ? notionNotHaveProject : ""}
                                                <h4 class="card-title">Overview of Project</h4>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <c:if test="${checkProject}">
                                                <p>ID: ${project.projectID}</p>
                                                <p>Title: ${project.title}</p>
                                                <p>Description: ${project.description}</p>
                                                <p>Score: ${project.scorce != null && processing == 100? project.scorce : ""}</p>
                                            </c:if>
                                        </div>
                                    </div>
                                    <c:if test="${checkProject}">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-8">
                                                                <div class="row align-items-center">
                                                                    <div class="col-md-3">
                                                                        <div id="circle-progress-21" class="circle-progress-01 circle-progress circle-progress-primary" data-min-value="0" data-max-value="100" data-value="${processing}" data-type="percent"></div>
                                                                    </div>
                                                                    <div class="col-md-9">
                                                                        <div class="mt-3 mt-md-0">
                                                                            <h5 class="mb-1">Processing of Project</h5>
                                                                            <p class="mb-0">Exclusively for cloud-based/ Startup theme.</p>
                                                                        </div>                                                        
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4 text-sm-right mt-3 mt-sm-0">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4">
                            <div class="card card-block card-stretch card-height">
                                <div class="card-body">
                                    <div class="card border-bottom pb-2 shadow-none">
                                        <div class="card-body text-center inln-date flet-datepickr">
                                            <input type="text" id="inline-date" class="date-input basicFlatpickr d-none" readonly="readonly">
                                        </div>
                                    </div>
<!--                                    <div class="card card-list">
                                        <div class="card-body">
                                            <div class="d-flex align-items-center">
                                                <svg class="svg-icon text-secondary mr-3" width="24" height="24" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                                <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"></path>
                                                </svg>
                                                <div class="pl-3 border-left">
                                                    <h5 class="mb-1">Direct Development</h5>
                                                    <p class="mb-0">Unveling the design system</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>-->
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
    </body>
</html>