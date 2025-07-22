/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ProjectDAO;
import dao.ReviewerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Project;
import model.Reviewer;

/**
 *
 * @author Acer
 */
public class SetReviewerToJuding extends HttpServlet {

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
            out.println("<title>Servlet SetReviewerToJuding</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SetReviewerToJuding at " + request.getContextPath() + "</h1>");
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

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        String[] checkBoxReviewer = request.getParameterValues("reviewer");
        String projectCode = request.getParameter("projectCode");
        String errorMessage = "";

        try {
            if (checkBoxReviewer == null || checkBoxReviewer.length != 3) {
                errorMessage = "Hãy chọn đúng 3 reviewer";
                request.setAttribute("errorMessage", errorMessage);
            }
        } catch (Exception e) {
            errorMessage = "Hãy chọn đúng 3 reviewer";
            request.setAttribute("errorMessage", errorMessage);
        }
        String judingID;

        try {
            judingID = String.join(",", checkBoxReviewer); // ví dụ: "r1,r2,r3"
            ProjectDAO projectDAO = new ProjectDAO();
            projectDAO.adminSetJudingIDproject(projectCode, judingID);
            errorMessage = "Thành công";
            request.setAttribute("errorMessage", errorMessage);
        } catch (Exception e) {
            errorMessage = "Hãy chọn đúng 3 reviewer";
            request.setAttribute("errorMessage", errorMessage);
        }
        //Load lại data RV
        ReviewerDAO r = new ReviewerDAO();
        List<Reviewer> listAllReviewer = r.readAll();
        request.setAttribute("listAllReviewer", listAllReviewer);
        
        ProjectDAO p = new ProjectDAO();
        List<Project> listAllProject = p.readAll();
        request.setAttribute("listAllProject", listAllProject);

        request.getRequestDispatcher("/jsp/admin/allproject.jsp").forward(request, response);
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
        processRequest(request, response);
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
