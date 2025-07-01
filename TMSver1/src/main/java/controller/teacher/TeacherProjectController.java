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
import java.util.*;
import model.*;

/**
 *
 * @author admin
 */
public class TeacherProjectController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
    // Lấy session, không tạo mới nếu chưa có
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }

        // Lấy teacherID từ session
        String teacherID = (String) session.getAttribute("user");

        // Truy vấn danh sách Project theo teacherID
        ProjectDAO p = new ProjectDAO();
        List<Project> listProject = p.readAllByTeaID(teacherID);

        // Xử lý nếu null
        if (listProject == null) {
            listProject = new ArrayList<>();
        }

        // Đặt dữ liệu lên request
        request.setAttribute("listProject", listProject);

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/teacher/teacherproject.jsp").forward(request, response);
    }

}
