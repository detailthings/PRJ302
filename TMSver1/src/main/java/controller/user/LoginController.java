/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dao.UserAccDAO;
import dao.UserAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserAccount;

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
//            UserAccountDAO uad = new UserAccountDAO();
//            UserAccount a = uad.getUserAccount(user, pass);

            UserAccDAO uad = new UserAccDAO();
            UserAccount a = uad.getUserBy(user, pass);
                     
            
            if(a != null) {
                session.setAttribute("user", user);
                session.setAttribute("pass", pass);
                session.setAttribute("name", a.getFullName());
                String role = a.getRole();
                switch (role) {
                    case "admin":
                        response.sendRedirect("jsp/admin/home.jsp");
                        break;
                    case "teacher":
                        response.sendRedirect("jsp/teacher/home.jsp");
                        break;
                    case "reviewer":
                        response.sendRedirect("jsp/reviewer/home.jsp");
                        break;
                    case "student":
                        response.sendRedirect("jsp/student/index.jsp");
                        break;
                    default:
                        response.sendRedirect("jsp/common/layout/login.jsp");
                }
            } else {
                response.sendRedirect("jsp/common/layout/login.jsp");
            }
        } catch(Exception e) {
            
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
