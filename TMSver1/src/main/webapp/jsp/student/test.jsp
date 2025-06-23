<%-- 
    Document   : test
    Created on : Jun 21, 2025, 10:02:46 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.ProjectDAO" %>
<%@ page import="model.Project" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                <%  } }
                %>
                </tfoot>
        </table>
    </body>
</html>
