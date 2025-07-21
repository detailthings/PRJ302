/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import util.Validation;

/**
 *
 * @author admin
 */
public class ChangePassWordController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        
        String user = (String) session.getAttribute("user");
        UserAccDAO u = new UserAccDAO();
        UserAccount a = (UserAccount) session.getAttribute("useraccount");
        
        String cpass = (String) request.getParameter("cpass");
        String npass = (String) request.getParameter("npass");
        String vpass = (String) request.getParameter("vpass");
        try {
            if(!a.getPassWord().equals(Validation.encryptionMD5(cpass)) || !vpass.equals(npass)) {
                String err = "Wrong old pass or repass not match newpass";
                request.setAttribute("notice", err);
            } else {
                a.setPassWord(Validation.encryptionMD5(npass));
                u.update(a);
                String suc = "Change password succesfull";
                request.setAttribute("notice", suc);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePassWordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("useraccount", a);
        
        String role = a.getRole();
        switch (role) {
                    case "admin":
                        request.setAttribute("adminprofile", u);
                        request.getRequestDispatcher("");
                        break;
                    case "teacher":
                        Teacher profileT = new TeacherDAO().readOnly(user);
                        request.setAttribute("teacherprofile", profileT);
                        request.getRequestDispatcher("/jsp/teacher/userprofileedit.jsp").forward(request, response);
                        break;
                    case "reviewer":
                        Reviewer profileR = new ReviewerDAO().readOnly(user);
                        request.setAttribute("reviewerprofile", profileR);
                        request.getRequestDispatcher("/jsp/reviewer/userprofileedit.jsp").forward(request, response);
                        break;
                    case "student":
                        Student profileS = new StudentDAO().readOnly(user);
                        request.setAttribute("studentprofile", profileS);
                        request.getRequestDispatcher("/jsp/student/userprofileedit.jsp").forward(request, response);
                        break;
                }
    }

}
