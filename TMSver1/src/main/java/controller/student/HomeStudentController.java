/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.student;

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
import model.UserAccount;

/**
 *
 * @author admin
 */
public class HomeStudentController extends HttpServlet {

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
//        String studentID = (String) session.getAttribute("user");
//        // Đặt dữ liệu lên request
//        request.setAttribute("studentID", studentID);

        
        //Student name and ID
        Student studentProfile = (Student) session.getAttribute("studentprofile");
        UserAccount useraccount = (UserAccount) session.getAttribute("useraccount");
        request.setAttribute("studentProfile", studentProfile);
        request.setAttribute("useraccount", useraccount);
        String studentID = studentProfile.getStudentCode();
        
        //Project
        SubmissionDAO s = new SubmissionDAO();
        List<DaSaP> dasap = s.readAllByStuID(studentID);
        boolean checkProject = true;
        if(dasap==null || dasap.size()==0) {
            request.setAttribute("notionNotHaveProject", "You have not joined any project!");
            checkProject = false;
        } else {
            request.setAttribute("project", dasap.get(0).getProject());
            int count = 0;
            for(DaSaP da : dasap) {
                if(da.getSubmission().getStatus().equals("Done")) {
                    count++;
                }
            }
            request.setAttribute("processing", (int)(count/dasap.size())*100);
        }
        request.setAttribute("checkProject", checkProject);
        // Chuyển tiếp sang JSP hiển thị
        request.getRequestDispatcher("/jsp/student/index.jsp").forward(request, response);

    }

}
