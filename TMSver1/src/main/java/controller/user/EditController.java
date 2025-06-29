/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author admin
 */
@WebServlet(name="EditController", urlPatterns={"/editcontroller"})
public class EditController extends HttpServlet {
   
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
        request.setAttribute("useraccount", u);
        
        String role = u.getRole();
        switch (role) {
            case "student":
                Student profileS = new StudentDAO().readOnly(user);
                request.setAttribute("studentprofile", profileS);
                request.getRequestDispatcher("/jsp/student/userprofileedit.jsp").forward(request, response);
                break;
            case "teacher":
                Teacher profileT = new TeacherDAO().readOnly(user);
                request.setAttribute("teacherprofile", profileT);
                request.getRequestDispatcher("/jsp/teacher/userprofileedit.jsp").forward(request, response);
                break;
            case "reviewer":
                Reviewer profileR = new ReviewerDAO().readOnly(user);
                request.setAttribute("reviewerprofile", profileR);
                request.getRequestDispatcher("/jsp/reviewer/userprofileedit.jsp").forward(request, response);
                break;
            case "admin":
                request.setAttribute("adminprofile", u);
                request.getRequestDispatcher("/jsp/admin/userprofileedit.jsp").forward(request, response);
                break;
        }
    } 

}
