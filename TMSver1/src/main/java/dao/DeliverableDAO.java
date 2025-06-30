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
import model.Deliverable;
import java.sql.Date;  

/**
 *
 * @author Acer
 */
public class DeliverableDAO extends DAO<Deliverable>{
    @Override
    public List<Deliverable> readAll() {
        try {
            List<Deliverable> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "select * from  Deliverable ";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("DeliverableID");
                    String title = rs.getString("Title");
                    String department = rs.getString("Description");
                    float weighting = rs.getFloat("Weighting");
                    Date SubmissionOpenDate  = rs.getDate("SubmissionOpenDate");
                    Date DueDate = rs.getDate("DueDate");
                    newList.add(new Deliverable(id, title, department, weighting, SubmissionOpenDate, DueDate));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(DeliverableDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) {
        DeliverableDAO dao = new DeliverableDAO();
        List<Deliverable> list = dao.readAll();
        
        if (list != null) {
            for (Deliverable d : list) {
                System.out.println(d);
            }
        } else {
            System.out.println("Không lấy được dữ liệu từ cơ sở dữ liệu.");
        }
    }
}
