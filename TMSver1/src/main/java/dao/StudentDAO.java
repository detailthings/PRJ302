/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author admin
 */
public class StudentDAO extends DAO {

    public int create(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBconnect.connectDB()) {
                String sql = "Insert Into Student(id, name, email, major)"
                        +"Value(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
                ps.setString(2, t.getName());
                ps.setString(3, t.getEmail());
                ps.setString(4, t.getMajor());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int update(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBconnect.connectDB()) {
                String sql = "Update student"
                        +"Set name=?, email=?, major=?"
                        +"Where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(4, t.getId());
                ps.setString(1, t.getName());
                ps.setString(2, t.getEmail());
                ps.setString(3, t.getMajor());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int delete(Student t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBconnect.connectDB()) {
                String sql = "Delete student Where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getId());
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
            try (Connection conn = DBconnect.connectDB()) {
                newList = new ArrayList<>();
                String sql = "Select * From student s";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    // Giả sử bảng Region có 2 cột: RegionID (int), RegionName (String)
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String major = rs.getString("major");
                    newList.add(new Student(id,name,email,major));
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
            Student student;
            PreparedStatement ps;
            try (Connection conn = DBconnect.connectDB()) {
                student = null;
                String sql = "Select * From student s where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    // Giả sử bảng Region có 2 cột: RegionID (int), RegionName (String)
                    student = new Student();
                    student.setId(rs.getString("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setMajor(rs.getString("major"));
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
