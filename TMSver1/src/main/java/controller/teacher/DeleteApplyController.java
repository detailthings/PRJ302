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
public class DeleteApplyController extends HttpServlet {
   
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
        Request deleteRequest = r.readOnly(requestID);
        r.delete(deleteRequest);
        
        response.sendRedirect("teacherapplycontroller");
    } 

}
