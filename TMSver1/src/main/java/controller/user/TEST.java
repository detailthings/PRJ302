/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.user;

import dao.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserAccount;

/**
 *
 * @author admin
 */
public class TEST {
    public static void main(String[] args) throws SQLException {
//            UserAccount a = new UserAccount();
//            Connection conn = DBcontext.connectDB();
//            PreparedStatement ps = conn.prepareStatement("Select * From UserAccount Where (Username = ? OR Email = ?) AND Password = ?");
//            ps.setString(1, "he190177");
//            ps.setString(2, "he190177");
//            ps.setString(3, "duchieu1901"); 
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                a = new UserAccount();
//                a.setUserID(rs.getString("UserID"));
//                a.setPassWord(rs.getString("Password"));
//                a.setFullName(rs.getString("FullName"));
//                a.setEmail(rs.getString("Email"));
//                a.setRole(rs.getString("Role"));
//                System.out.println(a.getRole());
//            }
//            rs.close();
//            ps.close();
//            conn.close();
            try {
            Connection conn = DBcontext.connectDB();
            PreparedStatement ps = conn.prepareStatement("Select * From UserAccount Where (Username = ? OR Email = ?) AND Password = ?");
            ps.setString(1, "he190177");
            ps.setString(2, "he190177");
            ps.setString(3, "duchieu1901"); 
            System.out.println("sss");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String role = rs.getString("Role");

                System.out.println("Role: " + role);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
