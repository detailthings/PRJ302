/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.*;

/**
 *
 * @author admin
 */
public class EditProfileController extends HttpServlet {
   
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
        String user = (String) session.getAttribute("user");
        
        UserAccDAO uDAO = new UserAccDAO();
        UserAccount u = uDAO.readOnly(user);
        
        String role = u.getRole();
        switch (role) {
            case "student":
                StudentDAO sDAO = new StudentDAO();
                Student profileS = new StudentDAO().readOnly(user);
                String fullnameS = (String)request.getParameter("fullname");
                String emailS = (String)request.getParameter("email");
                
                u.setFullName(fullnameS);
                u.setEmail(emailS);
                
                
                uDAO.update(u);
                session.setAttribute("name", u.getFullName());
                session.setAttribute("useraccount", u);
                
                request.setAttribute("studentprofile", profileS);
                request.getRequestDispatcher("/jsp/student/userprofile.jsp").forward(request, response);
                break;
            case "teacher":
                Teacher profileT = new TeacherDAO().readOnly(user);
                TeacherDAO tDAO = new TeacherDAO();
                String fullnameT = (String) request.getParameter("fullname");
                String emailT = (String) request.getParameter("email");
                
                u.setFullName(fullnameT);
                u.setEmail(emailT);
                
                uDAO.update(u);
                session.setAttribute("name", u.getFullName());
                session.setAttribute("email", u.getEmail());
                request.setAttribute("teacherprofile", profileT);
                request.getRequestDispatcher("/jsp/teacher/userprofile.jsp").forward(request, response);
                break;
            case "reviewer":
                Reviewer profileR = new ReviewerDAO().readOnly(user);
                request.setAttribute("reviewerprofile", profileR);
                request.getRequestDispatcher("/jsp/reviewer/userprofile.jsp").forward(request, response);
                break;
            case "admin":
                request.setAttribute("adminprofile", u);
                request.getRequestDispatcher("/jsp/admin/userprofile.jsp").forward(request, response);
                break;
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        
        
    }    

}
