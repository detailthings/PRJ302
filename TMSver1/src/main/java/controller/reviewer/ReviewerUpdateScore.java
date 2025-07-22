/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.reviewer;

import dao.ProjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Project;

/**
 *
 * @author Acer
 */
public class ReviewerUpdateScore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet ReviewerUpdateScore</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewerUpdateScore at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/jsp/common/layout/login.jsp");
            return;
        }
        
        // Lấy teacherID từ session
        String reviewerID = (String) session.getAttribute("user");
        String judgingID = (String) session.getAttribute("judgingID");
        // Truy vấn danh sách Project theo teacherID
        ProjectDAO p = new ProjectDAO();
        List<Project> listProject = p.readByReviewer(reviewerID);

        // Xử lý nếu null
        if (listProject == null) {
            listProject = new ArrayList<>();
        }

        // Đặt dữ liệu lên request
        request.setAttribute("listProject", listProject);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/reviewer/ReviewerProject.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String projectCode = request.getParameter("projectCode");
        String scoreStr = request.getParameter("score");

        try {
            float score = Float.parseFloat(scoreStr);

            ProjectDAO dao = new ProjectDAO();
            dao.reviewerUpdateScore(projectCode, score);

            // Quay lại trang chấm điểm
            response.sendRedirect("ReviewerUpdateScore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
