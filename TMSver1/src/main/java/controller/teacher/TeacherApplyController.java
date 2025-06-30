/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.*;
import model.*;

/**
 *
 * @author admin
 */
public class TeacherApplyController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/jsp/common/layout/login.jsp");
            return;
        }
        
        Teacher t = (Teacher) session.getAttribute("teacherprofile");
        RequestDAO r = new RequestDAO();
        List<Request> listAllRequest = r.readAllTeacher(t.getId());
        request.setAttribute("listAllRequest", listAllRequest);
        request.getRequestDispatcher("/jsp/teacher/teacherapply.jsp").forward(request, response);
    } 

}
