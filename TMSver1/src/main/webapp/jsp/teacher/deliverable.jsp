<%-- 
    Document   : deliverable
    Created on : Jun 18, 2025, 4:42:57 PM
    Author     : admin
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <%@include file="/jsp/common/layout/slidebarteacher.jsp" %>     <div class="iq-top-navbar">
                <%@include file="/jsp/common/layout/navteacher.jsp" %>  
            </div>      <div class="content-page">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-wrap align-items-center justify-content-between breadcrumb-content">
                                        <h5>Your Task_${studentID}_${p}</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach var="d" items="${dasap}">
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="card card-widget task-card">
                                                    <div class="card-body">
                                                        <div class="d-flex flex-wrap align-items-center justify-content-between">
                                                            <div class="d-flex align-items-center">
                                                                <div class="custom-control custom-task custom-checkbox custom-control-inline">
                                                                    <input type="checkbox" class="custom-control-input" id="customCheck01"
                                                                           ${d.submission.path!=null ? "checked" : ""}>
                                                                    <label class="custom-control-label" for="customCheck01"></label>
                                                                </div>
                                                                <div>
                                                                    <h5 class="mb-2">${d.deliverable.title}</h5>
                                                                </div>
                                                            </div>
                                                            <div class="media align-items-center mt-md-0 mt-3">
                                                                <a href="#" class="btn bg-secondary-light mr-3">Design</a>
                                                                <a class="btn bg-secondary-light" data-toggle="collapse" href="#collapseEdit1${d.deliverable.deliverableID}" role="button" aria-expanded="false" aria-controls="collapseEdit1${d.deliverable.deliverableID}"><i class="ri-edit-box-line m-0"></i></a>
                                                            </div>
                                                        </div>  
                                                    </div>
                                                </div>                                                                                                        
                                                <div class="collapse" id="collapseEdit1${d.deliverable.deliverableID}">                                            
                                                    <div class="card card-list task-card">
                                                        <div class="card-header d-flex align-items-center justify-content-between px-0 mx-3">
                                                            <div class="header-title">
                                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                                    <input type="checkbox" class="custom-control-input" id="customCheck05"
                                                                           ${d.submission.path!=null ? "checked" : ""}>
                                                                    <label class="custom-control-label h5" for="customCheck05">Mark as done</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="card-body">
                                                            <div class="form-group mb-3 position-relative">
                                                                <input type="text" class="form-control bg-white" placeholder="Design landing page of webkit">
                                                                <a href="#" class="task-edit task-simple-edit text-body"><i class="ri-edit-box-line"></i></a>
                                                            </div>
                                                            <div class="card mb-3">
                                                                <div class="card-body">
                                                                    <div class="row">
                                                                        <div class="col-lg-6">
                                                                            <div class="form-group mb-0">
                                                                                <label for="exampleInputText2" class="h5">Weighting</label>
                                                                                <p>${d.deliverable.weighting}%</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-lg-6">
                                                                            <div class="form-group mb-0">
                                                                                <label for="exampleInputText3" class="h5">Due Dates</label>
                                                                                <p>${d.deliverable.dueDate}</p>
                                                                            </div>                        
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="card mb-3">
                                                                <div class="card-body">
                                                                    <div class="row">
                                                                        <div class="col-lg-6">                                                        
                                                                            <h5 class="mb-2">Description</h5>
                                                                            <p class="mb-0">${d.deliverable.description}</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <form action="uploadfilecontroller" method="post" enctype="multipart/form-data">
<!--                                                            <div class="form-group mb-0">
                                                                <label for="exampleInputText01" class="h5">Attachments</label>
                                                                <div class="custom-file">
                                                                    <input type="file" name="file" class="custom-file-input" id="inputGroupFile001">
                                                                    <label class="custom-file-label" for="inputGroupFile001">Upload file</label>
                                                                    <input type="hidden" name="id" value="${d.submission.submissionID}">
                                                                </div>
                                                            </div>-->
                                                            <div>
                                                                <c:if test="${not empty d.submission.path}">
                                                                    <p>File: 
                                                                        <a href="downloadfilecontroller?path=${d.submission.path}">${fn:substringAfter(d.submission.path, '_')}</a>
                                                                    </p>
                                                                </c:if>
                                                            </div>
                                                            <div>
                                                                </br><button type="submit" class="btn bg-secondary-light mr-3">Upload</button>
                                                            </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>      
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                                    <h3>${checkDone != null ? checkDone : ""}</h3>
                        <!-- Page end  -->
                    </div>
                </div>
            </div>
            <!-- Wrapper End-->
            <%@include file="/jsp/common/layout/footer.jsp" %>
            <%@include file="/jsp/common/layout/js.jsp" %>
    </body>
</html>
