/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Submission;

/**
 *
 * @author admin
 */
public class SubmissionDAO extends DAO<Submission> {

    @Override
    public int create(Submission t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Submission(ProjectID, DeliverableID, SubmissionDate, LastModified, Status) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getProjectID());
                ps.setInt(2, t.getDeliverableID());
                ps.setTimestamp(3, t.getSubmissionDate());
                ps.setTimestamp(4, t.getLastModified());
                ps.setString(5, t.getStatus());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Submission t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Submission SET ProjectID=?, DeliverableID=?, SubmissionDate=?, LastModified=?, Status=? WHERE SubmissionID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getProjectID());
                ps.setInt(2, t.getDeliverableID());
                ps.setTimestamp(3, t.getSubmissionDate());
                ps.setTimestamp(4, t.getLastModified());
                ps.setString(5, t.getStatus());
                ps.setInt(6, t.getSubmissionID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Submission t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Submission WHERE SubmissionID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getSubmissionID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Submission> readAll() {
        try {
            List<Submission> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Submission";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int submissionID = rs.getInt("SubmissionID");
                    String projectID = rs.getString("ProjectID");
                    int deliverableID = rs.getInt("DeliverableID");
                    Timestamp submissionDate = rs.getTimestamp("SubmissionDate");
                    Timestamp lastModified = rs.getTimestamp("LastModified");
                    String status = rs.getString("Status");
                    newList.add(new Submission(submissionID, projectID, deliverableID, submissionDate, lastModified, status));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Submission readOnly(String str) {
        try {
            Submission submission = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Submission WHERE SubmissionID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    submission = new Submission();
                    submission.setSubmissionID(rs.getInt("SubmissionID"));
                    submission.setProjectID(rs.getString("ProjectID"));
                    submission.setDeliverableID(rs.getInt("DeliverableID"));
                    submission.setSubmissionDate(rs.getTimestamp("SubmissionDate"));
                    submission.setLastModified(rs.getTimestamp("LastModified"));
                    submission.setStatus(rs.getString("Status"));
                }
            }
            ps.close();
            return submission;
        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
