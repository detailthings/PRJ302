<%-- 
    Document   : userprofile
    Created on : Jun 22, 2025, 7:40:10 PM
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

            <%@include file="/jsp/common/layout/slidebarstudent.jsp" %>
            <%@include file="/jsp/common/layout/navstudent.jsp" %>      
            <div class="content-page">
                <div class="tab-pane fade active show" id="personal-information" role="tabpanel">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="iq-header-title">
                                <h4 class="card-title">Personal Information</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="form-group row align-items-center">
                                    <div class="col-md-12">
                                        <div class="profile-img-edit">
                                            <div class="crm-profile-img-edit">
                                                <img class="crm-profile-pic rounded-circle avatar-100" src="../assets/images/user/11.png" alt="profile-pic">
                                                <div class="crm-p-image bg-primary">
                                                    <i class="las la-pen upload-button"></i>
                                                    <input class="file-upload" type="file" accept="image/*">
                                                </div>
                                            </div>                                          
                                        </div>
                                    </div>
                                </div>
                                <div class=" row align-items-center">
                                    <% Student s = (Student) request.getAttribute("studentprofile"); %>
                                    <% UserAccount u = (UserAccount) ss.getAttribute("useraccount"); %>
                                    <div class="form-group col-sm-6">
                                        <label for="fname">User ID:</label>
                                        <%=u.getUserID() %>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="lname">Full Name:</label>
                                        <%=u.getFullName() %>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="uname">Email:</label>
                                        <%=u.getEmail() %>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="cname">Role:</label>
                                        <%=u.getRole() %>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="dob">Student Code:</label>
                                        <%=s.getStudentCode() %>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="dob">Major:</label>
                                        <%=s.getMajor() %>
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
