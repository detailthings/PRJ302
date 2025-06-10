/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Deliverable;

/**
 *
 * @author admin
 */
public class DeliverableDAO extends DAO<Deliverable> {

    @Override
    public int create(Deliverable t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Deliverable(Title, Description, Weighting, SubmissionOpenDate, DueDate) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getTitle());
                ps.setString(2, t.getDescription());
                ps.setFloat(3, t.getWeighting());
                ps.setDate(4, t.getSubmissionOpenDate());
                ps.setDate(5, t.getDueDate());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Deliverable t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Deliverable SET Title=?, Description=?, Weighting=?, SubmissionOpenDate=?, DueDate=? WHERE DeliverableID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getTitle());
                ps.setString(2, t.getDescription());
                ps.setFloat(3, t.getWeighting());
                ps.setDate(4, t.getSubmissionOpenDate());
                ps.setDate(5, t.getDueDate());
                ps.setInt(6, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Deliverable t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Deliverable WHERE DeliverableID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Deliverable> readAll() {
        try {
            List<Deliverable> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Deliverable";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int deliverableID = rs.getInt("DeliverableID");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    float weighting = rs.getFloat("Weighting");
                    Date submissionOpenDate = rs.getDate("SubmissionOpenDate");
                    Date dueDate = rs.getDate("DueDate");
                    newList.add(new Deliverable(deliverableID, title, description, weighting, submissionOpenDate, dueDate));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Deliverable readOnly(String str) {
        try {
            Deliverable deliverable = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Deliverable WHERE DeliverableID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    deliverable = new Deliverable();
                    deliverable.setId(rs.getInt("DeliverableID"));
                    deliverable.setTitle(rs.getString("Title"));
                    deliverable.setDescription(rs.getString("Description"));
                    deliverable.setWeighting(rs.getFloat("Weighting"));
                    deliverable.setSubmissionOpenDate(rs.getDate("SubmissionOpenDate"));
                    deliverable.setDueDate(rs.getDate("DueDate"));
                }
            }
            ps.close();
            return deliverable;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
