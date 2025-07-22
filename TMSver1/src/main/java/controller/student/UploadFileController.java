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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Paths;
import model.Deliverable;
import model.Submission;
/**
 *
 * @author admin
 */
@MultipartConfig(
            fileSizeThreshold = 1024 * 1024 * 1, // 1MB
            maxFileSize = 1024 * 1024 * 10, // 10MB
            maxRequestSize = 1024 * 1024 * 15 // 15MB
    )

public class UploadFileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/TMSver1/jsp/common/layout/login.jsp");
            return;
        }
        String studentID = (String) session.getAttribute("user");

        int submissionID = Integer.parseInt(request.getParameter("id")); // hidden input

        Part filePart = request.getPart("file");
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String saveDir = getServletContext().getRealPath("/") + "uploads/" + studentID;
        File dir = new File(saveDir);
        if (!dir.exists()) dir.mkdirs();

        String savedFileName = submissionID + "_" + originalFileName;
        String filePath = saveDir + "/" + savedFileName;
        filePart.write(filePath);

        // Lưu đường dẫn vào DB (tùy bạn dùng Hibernate hay JDBC)
        String dbPath = "uploads/" + studentID + "/" + savedFileName;
        SubmissionDAO dao = new SubmissionDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Submission newSub = dao.readOnlyByID(id);
        newSub.setPath(dbPath);
        newSub.setStatus("Done");
        dao.update(newSub);

        response.sendRedirect("deliverablecontroller"); // load lại danh sách deliverables
    }

}
