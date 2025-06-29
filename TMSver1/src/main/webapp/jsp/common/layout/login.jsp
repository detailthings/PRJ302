<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Webkit | Responsive Bootstrap 4 Admin Dashboard Template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" href="${path}/jsp/assets/images/favicon.ico" />
        <link rel="stylesheet" href="${path}/jsp/assets/css/backend-plugin.min.css">
        <link rel="stylesheet" href="${path}/jsp/assets/css/backend.css?v=1.0.0">
        <link rel="stylesheet" href="${path}/jsp/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
        <link rel="stylesheet" href="${path}/jsp/assets/vendor/remixicon/fonts/remixicon.css">

        <link rel="stylesheet" href="${path}/jsp/assets/vendor/tui-calendar/tui-calendar/dist/tui-calendar.css">
        <link rel="stylesheet" href="${path}/jsp/assets/vendor/tui-calendar/tui-date-picker/dist/tui-date-picker.css">
        <link rel="stylesheet" href="${path}/jsp/assets/vendor/tui-calendar/tui-time-picker/dist/tui-time-picker.css">  
    </head>
    <body class=" ">
        <!-- loader Start -->
        <div id="loading">
            <div id="loading-center">
            </div>
        </div>
        <!-- loader END -->

        <div class="wrapper">
            <section class="login-content">
                <div class="container">
                    <div class="row align-items-center justify-content-center height-self-center">
                        <div class="col-lg-8">
                            <div class="card auth-card">
                                <div class="card-body p-0">
                                    <div class="d-flex align-items-center auth-content">
                                        <div class="col-lg-6 bg-primary content-left">
                                            <div class="p-3">
                                                <h2 class="mb-2 text-white">Sign In</h2>
                                                <p>Login to stay connected.</p>
                                                <form action="${path}/logincontroller" method="POST">
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="floating-label form-group">
                                                                <input class="floating-input form-control" type="username" name="username" placeholder=" ">
                                                                <label>Username</label>
                                                            </div>
                                                            <%
                                                                  String uerror = (String) request.getAttribute("uerror");
                                                                  if (uerror != null) {
                                                            %>
                                                            <div style="background-color: #fef2f2; color: #b91c1c; padding: 6px 10px; border-left: 4px solid #f87171; border-radius: 4px; font-size: 13px; margin-top: 5px; margin-bottom: 8px;">
                                                                <%= uerror %>
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="floating-label form-group">
                                                                <input class="floating-input form-control" type="password" name="password" placeholder=" ">
                                                                <label>Password</label>
                                                            </div>
                                                            <%
                                                                  String perror = (String) request.getAttribute("perror");
                                                                  if (perror != null) {
                                                            %>
                                                            <div style="background-color: #fef2f2; color: #b91c1c; padding: 6px 10px; border-left: 4px solid #f87171; border-radius: 4px; font-size: 13px; margin-top: 5px; margin-bottom: 8px;">
                                                                <%= perror %>
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        </div>
                                                            <%
                                                                String err = (String) request.getAttribute("err");
                                                                if (err != null) {
                                                            %>
                                                            <div style="background-color: #fef2f2; color: #b91c1c; padding: 6px 10px; border-left: 4px solid #f87171; border-radius: 4px; font-size: 13px; margin-top: 5px; margin-bottom: 8px;">
                                                                <%= err %>
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        <div class="col-lg-6">
                                                            <div class="custom-control custom-checkbox mb-3">
                                                                <input type="checkbox" class="custom-control-input" id="customCheck1">
                                                                <label class="custom-control-label control-label-1 text-white" for="customCheck1">Remember Me</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-6">
                                                            <a href="auth-recoverpw.html" class="text-white float-right">Forgot Password?</a>
                                                        </div>
                                                    </div>
                                                    <button type="submit" class="btn btn-white">Sign In</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 content-right">
                                            <img src="${path}/jsp/assets/images/login/01.png" class="img-fluid image-right" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <!-- Backend Bundle JavaScript -->
        <script src="${path}/jsp/assets/js/backend-bundle.min.js"></script>

        <!-- Table Treeview JavaScript -->
        <script src="${path}/jsp/assets/js/table-treeview.js"></script>

        <!-- Chart Custom JavaScript -->
        <script src="${path}/jsp/assets/js/customizer.js"></script>

        <!-- Chart Custom JavaScript -->
        <script async src="${path}/jsp/assets/js/chart-custom.js"></script>
        <!-- Chart Custom JavaScript -->
        <script async src="${path}/jsp/assets/js/slider.js"></script>

        <!-- app JavaScript -->
        <script src="${path}/jsp/assets/js/app.js"></script>

        <script src="${path}/jsp/assets/vendor/moment.min.js"></script>
    </body>
</html>