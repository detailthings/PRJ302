<%-- 
    Document   : reviewerUpdateScoreProject
    Created on : Jun 30, 2025, 1:24:19 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Deliverable" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                line-height: 1.6;
                background-color: #f9f9f9;
                color: #333;
            }

            header {
                background: url('https://source.unsplash.com/1600x400/?technology,project') no-repeat center center/cover;
                color: white;
                height: 300px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
            }

            header h1 {
                font-size: 3rem;
                background: rgba(0, 0, 0, 0.5);
                padding: 0.5em 1em;
                border-radius: 10px;
            }

            nav {
                background-color: #333;
                color: white;
                display: flex;
                justify-content: center;
                padding: 0.5em 0;
            }

            nav a {
                color: white;
                margin: 0 1em;
                text-decoration: none;
            }

            nav a:hover {
                text-decoration: underline;
            }

            .projects-container {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                gap: 1.5em;
                padding: 2em;
            }

            .project-card {
                background: #ccc;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                overflow: hidden;
                display: flex;
                flex-direction: column;
            }
            table{
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 12px;
                border: 1px solid #e2e8f0;
            }
            thead {
                background-color: #f7fafc;
                font-weight: bold;
            }
            tfoot {
                background-color: #edf2f7;
                text-align: right;
                font-style: italic;
            }
            .project-card img {
                width: 100%;
                height: 200px;
                object-fit: cover;
            }

            .project-card .content {
                padding: 1em;
                flex-grow: 1;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            }

            .project-card h3 {
                margin-bottom: 0.5em;
            }

            .project-card button {
                background-color: #007BFF;
                color: white;
                border: none;
                padding: 0.5em;
                border-radius: 5px;
                cursor: pointer;
                align-self: flex-start;
            }

            .project-card button:hover {
                background-color: #0056b3;
            }

            footer {
                background-color: #222;
                color: white;
                padding: 2em;
                text-align: center;
            }

            footer a {
                color: #ccc;
                margin: 0 0.5em;
                text-decoration: none;
            }

            footer a:hover {
                text-decoration: underline;
            }
        </style>
    </head>



    <body>
        <header>
            <h1>Hệ thống Quản lý Đồ Án</h1>
        </header>

        <nav>
            <a href="index.jsp">Trang chủ</a>
            <a href="TeacherReadProject">Đồ án</a>           
            <a href="#">Liên hệ</a>
            <a href="Login">Đăng nhập</a>
                    </nav>
                    <div class="project-card">
                        <%@ page import="java.util.*" %>
                        <%@ page import="model.Deliverable"%>
                        <%List<Deliverable> deli = (List<Deliverable>) request.getAttribute("deliverable");%>
                        <table class="tbReview" >
                            <thead>
                                <tr class="ligth">
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>SubmissionOpenDate</th>
                                    <th>DueDate</th>
                                    <th>tWeighting</th>

                                </tr>
                            </thead>
                            <tbody>

                                <%-- sửa để kiểm tra for null và empty --%>
                                <% if (deli != null&& !deli.isEmpty()) { %>
                                <% for (Deliverable d : deli) { %>
                                <tr>
                                    <td><%= d.getId()%></td>
                                    <td><%= d.getTitle()%></td>
                                    <td><%= d.getDescription()%></td>
                                    <td><%= d.getSubmissionOpenDate() %></td>
                                    <td><%= d.getDueDate() %></td>
                                    <td><%= d.getWeighting() %></td>
                                </tr>
                                <% } %>
                                <% } else { %>
                                <tr>
                                    <td colspan="2">No submission data found.</td>
                                </tr>
                                <% } %>




                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>SubmissionOpenDate</th>
                                    <th>DueDate</th>
                                    <th>tWeighting</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>            
                    <footer>
                        <p>&copy; 2025 Quản lý Đồ Án. Mọi quyền được bảo lưu.</p>
                        <div>
                            <a href="#">Chính sách bảo mật</a>|
                            <a href="#">Điều khoản sử dụng</a>
                        </div>
                    </footer>                    
                    </body>
                    </html>
