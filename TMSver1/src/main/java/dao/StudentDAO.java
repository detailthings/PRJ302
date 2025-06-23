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
import model.Student;

/**
 *
 * @author admin
 * @param <Student>
 */
public class StudentDAO extends DAO<Student>{
    
    @Override
    public int create(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Student(UserID, Major) VALUES(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getStudentID());
                ps.setString(2, t.getMajor());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Student SET UserID=?, Major=? WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getStudentID());
                ps.setString(2, t.getMajor());
                ps.setInt(3, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Student WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Student> readAll() {
        try {
            List<Student> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Student";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String userID = rs.getString("UserID");
                    String major = rs.getString("Major");
                    String group = rs.getString("GroupID");
                    newList.add(new Student(id, userID, major,group));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Student readOnly(String str) {
        try {
            Student student = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Student WHERE ID=? OR UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ps.setString(2, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("ID"));
                    student.setStudentID(rs.getString("UserID"));
                    student.setMajor(rs.getString("Major"));
                }
            }
            ps.close();
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
