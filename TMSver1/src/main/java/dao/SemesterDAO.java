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
import model.Semester;

/**
 *
 * @author admin
 */
public class SemesterDAO extends DAO<Semester> {

    @Override
    public int create(Semester t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Semester(SemesterID, Semester, Year, StartDate, EndDate) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
                ps.setString(2, t.getSemester());
                ps.setInt(3, t.getYear());
                ps.setDate(4, t.getStartDate());
                ps.setDate(5, t.getEndDate());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Semester t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Semester SET Semester=?, Year=?, StartDate=?, EndDate=? WHERE SemesterID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getSemester());
                ps.setInt(2, t.getYear());
                ps.setDate(3, t.getStartDate());
                ps.setDate(4, t.getEndDate());
                ps.setString(5, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Semester t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Semester WHERE SemesterID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Semester> readAll() {
        try {
            List<Semester> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Semester";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String semesterID = rs.getString("SemesterID");
                    String semester = rs.getString("Semester");
                    int year = rs.getInt("Year");
                    Date startDate = rs.getDate("StartDate");
                    Date endDate = rs.getDate("EndDate");
                    newList.add(new Semester(semesterID, semester, year, startDate, endDate));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Semester readOnly(String semesterID) {
        try {
            Semester semester = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Semester WHERE SemesterID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, semesterID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    semester = new Semester();
                    semester.setId(rs.getString("SemesterID"));
                    semester.setSemester(rs.getString("Semester"));
                    semester.setYear(rs.getInt("Year"));
                    semester.setStartDate(rs.getDate("StartDate"));
                    semester.setEndDate(rs.getDate("EndDate"));
                }
            }
            ps.close();
            return semester;
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}