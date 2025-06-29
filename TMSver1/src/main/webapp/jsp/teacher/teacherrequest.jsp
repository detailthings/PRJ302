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
                            <% 
                                List<Request> listAllRequest = (List<Request>) request.getAttribute("listAllRequest");
                            %>
                            <% 
                                for(Request p : listAllRequest) {
                            %>
                                <div class="card">
                                    <div class="card-body"> 
                                        <h5 class="mb-3"><%=p.getTitle()%></h5>
                                        <p class="mb-3"><i class="las la-calendar-check mr-2"></i><%=p.getTeacherID()%></p>
                                        <p class="mb-3"><i class="las la-calendar-check mr-2"></i><%=p.getCreateAt()%></p>
                                        <p class="mb-3"><i class="las la-calendar-check mr-2"></i><%=p.getStatus()%></p>
                                        <div class="iq-progress-bar bg-success-light mb-4">
                                            <span class="bg-success iq-progress progress-1" data-percent="65" style="transition: width 2s ease 0s; width: 65%;"></span>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div>
                                                <a href="<%=request.getContextPath()%>/appliedcontroller?requestID=<%=p.getId()%>" class="btn bg-success-light">Accept</a>
                                                <a href="<%=request.getContextPath()%>/appliedcontroller?requestID=<%=p.getId()%>" class="btn bg-success-light">Reject</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <% 
                                }
                            %>
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