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
import model.Request;

/**
 *
 * @author admin
 */
public class RequestDAO extends DAO<Request> {

    @Override
    public int create(Request t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Request(StudentID, Title, Description, Status, TeacherID, Created_At) VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getStudentID());
                ps.setString(2, t.getTitle());
                ps.setString(3, t.getDescription());
                ps.setString(4, t.getStatus());
                ps.setInt(5, t.getTeacherID());
                ps.setTimestamp(6, t.getCreatedAt());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Request t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Request SET StudentID=?, Title=?, Description=?, Status=?, TeacherID=?, Created_At=? WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getStudentID());
                ps.setString(2, t.getTitle());
                ps.setString(3, t.getDescription());
                ps.setString(4, t.getStatus());
                ps.setInt(5, t.getTeacherID());
                ps.setTimestamp(6, t.getCreatedAt());
                ps.setInt(7, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Request t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Request WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Request> readAll() {
        try {
            List<Request> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Request";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int studentID = rs.getInt("StudentID");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    String status = rs.getString("Status");
                    int teacherID = rs.getInt("TeacherID");
                    Timestamp createdAt = rs.getTimestamp("Created_At");
                    newList.add(new Request(id, studentID, title, description, status, teacherID, createdAt));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Request readOnly(String str) {
        try {
            Request request = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Request WHERE ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, str);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    request = new Request();
                    request.setId(rs.getInt("ID"));
                    request.setStudentID(rs.getInt("StudentID"));
                    request.setTitle(rs.getString("Title"));
                    request.setDescription(rs.getString("Description"));
                    request.setStatus(rs.getString("Status"));
                    request.setTeacherID(rs.getInt("TeacherID"));
                    request.setCreatedAt(rs.getTimestamp("Created_At"));
                }
            }
            ps.close();
            return request;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
