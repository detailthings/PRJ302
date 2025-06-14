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
import model.Teacher;


/**
 *
 * @author admin
 */
public class TeacherDAO extends DAO<Teacher> {

    @Override
    public int create(Teacher t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Teacher(UserID, Department) VALUES(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getTeacherID());
                ps.setString(2, t.getDepartment());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Teacher t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Teacher SET UserID=?, Department=? WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getTeacherID());
                ps.setString(2, t.getDepartment());
                ps.setInt(3, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Teacher t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Teacher WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Teacher> readAll() {
        try {
            List<Teacher> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Teacher";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String userID = rs.getString("UserID");
                    String department = rs.getString("Department");
                    newList.add(new Teacher(id, userID, department));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Teacher readOnly(String str) {
        try {
            Teacher teacher = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Teacher WHERE ID=? OR UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ps.setString(2, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    teacher = new Teacher();
                    teacher.setId(rs.getInt("ID"));
                    teacher.setTeacherID(rs.getString("UserID"));
                    teacher.setDepartment(rs.getString("Department"));
                }
            }
            ps.close();
            return teacher;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
