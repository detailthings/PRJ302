/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

import dao.DeliverableDAO;
import dao.SubmissionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import model.DaSaP;
import model.Student;

/**
 *
 * @author admin
 */
public class DeliverableController extends HttpServlet {
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
//        String studentID = (String) session.getAttribute("user");
        Student studentProfile = (Student) session.getAttribute("studentprofile");
        String studentID = studentProfile.getStudentCode();
        DeliverableDAO d = new DeliverableDAO();
        SubmissionDAO s = new SubmissionDAO();
        List<DaSaP> dasap = s.readAllByStuID(studentID);
        int p = dasap.size();
        boolean checkDone = true;
        // Lấy studentID từ session
        // Check quá hạn/ Chưa tới hạn
        LocalDate getDateNow = LocalDate.now();

        for(DaSaP l : dasap) {
            if(l.getSubmission().getPath()==null) {
                checkDone = false;
            }
            LocalDate getStartDate = l.getDeliverable().getSubmissionOpenDate().toLocalDate();
            LocalDate getEndDate = l.getDeliverable().getDueDate().toLocalDate();
            l.setStatus(1);
            if(getStartDate.isBefore(getDateNow)) {
                if(getEndDate.isAfter(getDateNow)) {
                    l.setStatus(2);
                } else {
                    l.setStatus(3);
                }
            }
        }
        
        if(checkDone == true) {
            request.setAttribute("checkDone", "Done Project");
        }
        // Đặt dữ liệu lên request
        request.setAttribute("getDateNow", getDateNow);
        request.setAttribute("studentID", studentID);
        request.setAttribute("dasap", dasap);
        request.setAttribute("p", p); 

        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/student/deliverable.jsp").forward(request, response);
    } 

}
