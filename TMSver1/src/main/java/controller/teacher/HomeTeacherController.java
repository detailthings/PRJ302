/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dao.ProjectDAO;
import dao.RequestDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class HomeTeacherController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        // Lấy studentID từ session
        String teacherID = (String) session.getAttribute("user");
        // Đặt dữ liệu lên request
        request.setAttribute("teacherID", teacherID);
        
        RequestDAO r = new RequestDAO();
        ProjectDAO p = new ProjectDAO();
        //Number of request not have student ID:
        int numberOfRequestNotStudentID = r.readAllTeacher(teacherID).size();
        //Number of requeste hava student ID:
        int numberOfRequestHaveStudentID = r.readAllStudentApply(teacherID).size();
        //Number of Project:
        int numberOfProject = p.readAllByTeaID(teacherID).size();
        
        request.setAttribute("numberOfRequestNotStudentID", numberOfRequestNotStudentID);
        request.setAttribute("numberOfRequestHaveStudentID", numberOfRequestHaveStudentID);
        request.setAttribute("numberOfProject", numberOfProject);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/teacher/index.jsp").forward(request, response);

    }

}
