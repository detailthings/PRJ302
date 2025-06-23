/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.Teacher;

/**
 *
 * @author KHANH
 */
public class RequestDAO extends DAO {

    @Override
    public Object readOnly(String str) {
        return super.readOnly(str);
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
                    int StudentID = rs.getInt("StudentID");
                    String Title = rs.getString("Title");
                    String Description = rs.getString("Description");
                    String Status = rs.getString("Status");
                    int TeacherID = rs.getInt("TeacherID");
                    Timestamp createdAt = rs.getTimestamp("Created_At");
                    newList.add(new Request(id, StudentID, Title, Description, Status, TeacherID, createdAt));
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
    public int delete(Object t) {
        return super.delete(t);
    }

    @Override
    public int update(Object t) {
        return super.update(t);
    }

//    public void create(Request req) {
//        try {
//
//            PreparedStatement ps;
//            try (Connection conn = DBcontext.connectDB()) {
//                String sql = "INSERT INTO Request\n"
//                        + "                (StudentID, Title, Description, Status, TeacherID, Created_At)\n"
//                        + "                VALUES (?,?,?,?,?,?)";
//                ps = conn.prepareStatement(sql);
//
//                ps.setInt(1, req.getStudentID());                 // hoặc ps.setNull(1, Types.INTEGER);
//                ps.setString(2, req.getTitle());
//                ps.setString(3, req.getDescription());
//                ps.setString(4, "procesing");
//                ps.setInt(5, req.getTeacherID());                 // có thể setNull
//                ps.setTimestamp(6, req.getCreateAt());
//
//                ps.executeUpdate();
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//    }
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
                ps.setString(4, "processing");
                ps.setInt(5, t.getTeacherID());
                ps.setTimestamp(6, t.getCreateAt());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void main(String[] args) {
        RequestDAO o = new RequestDAO();
        Timestamp createAt = Timestamp.valueOf("2025-06-20 08:14:00.263");
        Request r = new Request(19, 19, "Tiêm", "none", "processing", 7, createAt);
        System.out.println(createAt);
        //return 0;
        o.create(r);
    }
}
