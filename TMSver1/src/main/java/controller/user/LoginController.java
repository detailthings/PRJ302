/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dao.ReviewerDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import dao.UserAccDAO;
import dao.UserAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Reviewer;
import model.Student;
import model.Teacher;
import model.UserAccount;
import util.Validation;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        UserAccount a = (UserAccount) session.getAttribute("useraccount");
           
        String role = a.getRole();
            switch (role) {
                case "admin":
                    response.sendRedirect("dashboardcontroller");
                    break;
                case "teacher":
                    Teacher profileT = new TeacherDAO().readOnly(user);
                    session.setAttribute("teacherprofile", profileT);
                    response.sendRedirect("hometeachercontroller");
                    break;
                case "reviewer":
                    Reviewer profileR = new ReviewerDAO().readOnly(user);
                    session.setAttribute("reviewerprofile", profileR);
                    response.sendRedirect("homereviewercontroller");
                    break;
                case "student":
                    Student profileS = new StudentDAO().readOnly(user);
                    session.setAttribute("studentprofile", profileS);
                    response.sendRedirect("homestudentcontroller");
                    break;
                default:
                    response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            boolean hasError = false;
            if (!Validation.checkUsername(user)) {
                request.setAttribute("uerror", "Username chỉ chứa a-z, A-Z, 0-9, dấu gạch dưới.");
                hasError = true;
            }
            if (!Validation.checkPassword(pass)) {
                request.setAttribute("perror", "Password phải có ít nhất 8 ký tự.");
                hasError = true;
            }
            if (hasError) {
                request.getRequestDispatcher("/jsp/common/layout/login.jsp").forward(request, response);
                return;
            }

            UserAccDAO uad = new UserAccDAO();
            UserAccount a = uad.getUserBy(user, pass);
                     
            
            if(a != null) {
                session.setAttribute("user", user);
                session.setAttribute("pass", pass);
                session.setAttribute("name", a.getFullName());
                session.setAttribute("useraccount", a);
                String role = a.getRole();
                switch (role) {
                    case "admin":
                        response.sendRedirect("dashboardcontroller");
                        break;
                    case "teacher":
                        Teacher profileT = new TeacherDAO().readOnly(user);
                        session.setAttribute("teacherprofile", profileT);
                        response.sendRedirect("hometeachercontroller");
                        break;
                    case "reviewer":
                        Reviewer profileR = new ReviewerDAO().readOnly(user);
                        session.setAttribute("reviewerprofile", profileR);
                        response.sendRedirect("homereviewercontroller");
                        break;
                    case "student":
                        Student profileS = new StudentDAO().readOnly(user);
                        session.setAttribute("studentprofile", profileS);
                        response.sendRedirect("homestudentcontroller");
                        break;
                    default:
                        response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
                }
            } else {
                request.setAttribute("err", "Sai tên tài khoản hoặc mật khẩu.");
                request.getRequestDispatcher("/jsp/common/layout/login.jsp").forward(request, response);
            }
        } catch(Exception e) {
            
        }
    }


}
