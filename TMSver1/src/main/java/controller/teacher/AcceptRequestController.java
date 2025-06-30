/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author admin
 */
public class AcceptRequestController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/jsp/common/layout/login.jsp");
            return;
        }
        // Lấy  từ session
        String teacherID = (String) session.getAttribute("user");
        String requestID = (String) request.getParameter("requestID");
        
        RequestDAO r = new RequestDAO();
        SemesterDAO s = new SemesterDAO();
        ProjectDAO p = new ProjectDAO();
        Request acceptRequest = r.readOnly(requestID);
        acceptRequest.setStatus("Accept");
        r.update(acceptRequest);
        
        Project newProject = new Project();
        newProject.setProjectID(requestID);
        newProject.setTitle(acceptRequest.getTitle());
        newProject.setDescription(acceptRequest.getDescription());
        newProject.setTeacherID(acceptRequest.getTeacherID());
        newProject.setStudentID(acceptRequest.getStudentID());
        newProject.setSemesterID(s.getSemester(acceptRequest.getCreateAt()));
        newProject.setJudgingID(null);
        newProject.setScorce(null);
        p.create(newProject);
        
        request.getRequestDispatcher("teacherprojectcontroller").forward(request, response);
    } 

}
