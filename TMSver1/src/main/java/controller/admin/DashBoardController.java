/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;


/**
 *
 * @author admin
 */
public class DashBoardController extends HttpServlet {

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
        String userID = (String) session.getAttribute("user");
        // Đặt dữ liệu lên request
        request.setAttribute("userID", userID);
        ProjectDAO p = new ProjectDAO();
        int numOfProjectAllSemester = p.countAllProject();
        String newestSemester = p.findNewestSemester();
        int numOfProjectNewestSemester = p.countAllProjectInNewestSemester(newestSemester);
        int numOfGoodProject = p.countNumerOfGoodProject(newestSemester);
        
        request.setAttribute("t1",numOfProjectAllSemester);
        request.setAttribute("t2",numOfProjectNewestSemester);
        request.setAttribute("t3",numOfGoodProject);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/admin/index.jsp").forward(request, response);
    } 

}
