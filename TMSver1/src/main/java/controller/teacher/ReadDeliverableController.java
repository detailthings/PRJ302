/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.teacher;

import dao.DeliverableDAO;
import dao.SubmissionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.DaSaP;
import model.Student;
import model.Teacher;

/**
 *
 * @author admin
 */
public class ReadDeliverableController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        String studentID = request.getParameter("studentID");
        Teacher teacherProfile = (Teacher) session.getAttribute("teacherprofile");
        DeliverableDAO d = new DeliverableDAO();
        SubmissionDAO s = new SubmissionDAO();
        List<DaSaP> dasap = s.readAllByStuID(studentID);
        int p = dasap.size();  
        
        boolean checkDone = true;
        // Lấy studentID từ session
        for(DaSaP l : dasap) {
            if(l.getSubmission().getPath()==null) {
                checkDone = false;
            }
        }
        if(checkDone == true) {
            request.setAttribute("checkDone", "Done Project");
        }
        // Check quá hạn/ Chưa tới hạn
        
        
        // Đặt dữ liệu lên request
        request.setAttribute("studentID", studentID);
        request.setAttribute("dasap", dasap);
        request.setAttribute("p", p); 

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/teacher/deliverable.jsp").forward(request, response);
    } 

}
