/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dao.*;
import model.*;
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
public class EditApplyController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        String requestID = (String) request.getParameter("requestID");
        
        RequestDAO r = new RequestDAO();
        Request editApply = r.readOnly(requestID);
        request.setAttribute("editApply", editApply);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/teacher/editapply.jsp").forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        String requestID = (String) request.getParameter("id");
        String studentID = (String) request.getParameter("studentID");
        String teacherID = (String) request.getParameter("teacherID");
        String status = (String) request.getParameter("status");
        String createAt = (String) request.getParameter("createAt");// suwr dungj dung form
        String title = (String) request.getParameter("title");
        String description = (String) request.getParameter("description");
        
        RequestDAO r = new RequestDAO();
        Request editApply = r.readOnly(requestID);
        editApply.setTitle(title);
        editApply.setDescription(description);
        r.update(editApply);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("teacherapplycontroller").forward(request, response);
    }

}
