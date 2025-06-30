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
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApplicationController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApplicationController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        response.sendRedirect("jsp/common/layout/login.jsp");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
//            PrintWriter out = response.getWriter();
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
//            UserAccountDAO uad = new UserAccountDAO();
//            UserAccount a = uad.getUserAccount(user, pass);

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
