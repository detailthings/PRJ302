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
import model.Judging;

/**
 *
 * @author admin
 */
public class JudgingDAO extends DAO<Judging> {

    @Override
    public int create(Judging t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Judging(JudgingID, ProjectCode, TeacherID, Reviewer1ID, Reviewer2ID) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
                ps.setString(2, t.getProjectCode());
                ps.setString(3, t.getTeacherID());
                ps.setString(4, t.getReviewer1ID());
                ps.setString(5, t.getReviewer2ID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(JudgingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Judging t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Judging SET ProjectCode=?, TeacherID=?, Reviewer1ID=?, Reviewer2ID=? WHERE JudgingID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getProjectCode());
                ps.setString(2, t.getTeacherID());
                ps.setString(3, t.getReviewer1ID());
                ps.setString(4, t.getReviewer2ID());
                ps.setString(5, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(JudgingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Judging t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Judging WHERE JudgingID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(JudgingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Judging> readAll() {
        try {
            List<Judging> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Judging";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String judgingID = rs.getString("JudgingID");
                    String projectCode = rs.getString("ProjectCode");
                    String teacherID = rs.getString("TeacherID");
                    String reviewer1ID = rs.getString("Reviewer1ID");
                    String reviewer2ID = rs.getString("Reviewer2ID");
                    newList.add(new Judging(judgingID, projectCode, teacherID, reviewer1ID, reviewer2ID));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(JudgingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Judging readOnly(String judgingID) {
        try {
            Judging judging = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Judging WHERE JudgingID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, judgingID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    judging = new Judging();
                    judging.setId(rs.getString("JudgingID"));
                    judging.setProjectCode(rs.getString("ProjectCode"));
                    judging.setTeacherID(rs.getString("TeacherID"));
                    judging.setReviewer1ID(rs.getString("Reviewer1ID"));
                    judging.setReviewer2ID(rs.getString("Reviewer2ID"));
                }
            }
            ps.close();
            return judging;
        } catch (SQLException ex) {
            Logger.getLogger(JudgingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
