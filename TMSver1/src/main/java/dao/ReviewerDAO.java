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
import model.Reviewer;

/**
 *
 * @author admin
 */
public class ReviewerDAO extends DAO<Reviewer> {

    @Override
    public int create(Reviewer t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Reviewer(UserID, Department) VALUES(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getReviewerID());
                ps.setString(2, t.getDepartment());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Reviewer t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Reviewer SET UserID=?, Department=? WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getReviewerID());
                ps.setString(2, t.getDepartment());
                ps.setInt(3, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Reviewer t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Reviewer WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Reviewer> readAll() {
        try {
            List<Reviewer> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Reviewer";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String userID = rs.getString("UserID");
                    String department = rs.getString("Department");
                    newList.add(new Reviewer(id, userID, department));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Reviewer readOnly(String str) {
        try {
            Reviewer reviewer = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Reviewer WHERE ID=? OR UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ps.setString(2, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    reviewer = new Reviewer();
                    reviewer.setId(rs.getInt("ID"));
                    reviewer.setReviewerID(rs.getString("UserID"));
                    reviewer.setDepartment(rs.getString("Department"));
                }
            }
            ps.close();
            return reviewer;
        } catch (SQLException ex) {
            Logger.getLogger(ReviewerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
