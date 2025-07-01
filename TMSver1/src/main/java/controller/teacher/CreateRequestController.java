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
import java.time.LocalDateTime;
import model.*;

/**
 *
 * @author admin
 */
public class CreateRequestController extends HttpServlet {
   
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
        String studentID = (String) session.getAttribute("user");
        // Đặt dữ liệu lên request
        request.setAttribute("studentID", studentID);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/teacher/createrequest.jsp").forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        // Lấy studentID từ session
        String teacherID = (String) session.getAttribute("user");
        String requestID = (String) request.getParameter("id");
        String title = (String) request.getParameter("title");
        String description = (String) request.getParameter("description");
        
        RequestDAO r = new RequestDAO();
        Request newRequest = new Request();
        newRequest.setId(requestID);
        newRequest.setStudentID(null);
        newRequest.setTeacherID(teacherID);
        newRequest.setTitle(title);
        newRequest.setDescription(description);
        newRequest.setStatus("None");
        newRequest.setCreateAt(LocalDateTime.now());
        
        r.create(newRequest);
        
        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("teacherapplycontroller").forward(request, response);
    } 
}
