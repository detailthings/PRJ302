/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

import dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.Request;
import model.Student;

/**
 *
 * @author admin
 */
public class ApplicationController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        
        Student s = (Student) session.getAttribute("studentprofile");
        
        RequestDAO r = new RequestDAO();
        Request newRequest = r.readOnly(s.getStudentCode());
        List<Request> listAllRequest = new ArrayList<>();
        if(newRequest!=null) {
            listAllRequest.add(newRequest);
        } else {
            listAllRequest = r.readAll();
        }
        request.setAttribute("listAllRequest", listAllRequest);
        request.getRequestDispatcher("/jsp/student/applyproject.jsp").forward(request, response);
    } 
    
}
