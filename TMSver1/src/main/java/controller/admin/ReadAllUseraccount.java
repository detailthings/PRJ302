/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class ReadAllUseraccount extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        UserAccDAO r = new UserAccDAO();
        List<UserAccount> listAllUserAccount = r.readAll();
        request.setAttribute("listAllUserAccount", listAllUserAccount);
        request.getRequestDispatcher("/jsp/admin/alluseraccount.jsp").forward(request, response);
    } 
}
