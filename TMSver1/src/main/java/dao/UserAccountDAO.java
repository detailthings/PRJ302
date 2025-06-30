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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserAccount;

/**
 *
 * @author admin
 */
public class UserAccountDAO extends DAO<UserAccount> {
    
     @Override
    public int create(UserAccount t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO UserAccount(UserID, Password, FullName, Email, Role) VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getUserID());
                ps.setString(2, t.getPassWord());
                ps.setString(3, t.getFullName());
                ps.setString(4, t.getEmail());
                ps.setString(5, t.getRole());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    } 

    @Override
    public int update(UserAccount t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE UserAccount SET Password=?, FullName=?, Email=?, Role=? WHERE UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getPassWord());
                ps.setString(2, t.getFullName());
                ps.setString(3, t.getEmail());
                ps.setString(4, t.getRole());
                ps.setString(5, t.getUserID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(UserAccount t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM UserAccount WHERE UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getUserID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<UserAccount> readAll() {
        try {
            List<UserAccount> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM UserAccount";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String password = rs.getString("Password");
                    String fullName = rs.getString("FullName");
                    String email = rs.getString("Email");
                    String role = rs.getString("Role");
                    newList.add(new UserAccount(userID, password, fullName, email, role));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public UserAccount readOnly(String userID) {
        try {
            UserAccount userAccount = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM UserAccount WHERE UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    userAccount = new UserAccount();
                    userAccount.setUserID(rs.getString("UserID"));
                    userAccount.setPassWord(rs.getString("Password"));
                    userAccount.setFullName(rs.getString("FullName"));
                    userAccount.setEmail(rs.getString("Email"));
                    userAccount.setRole(rs.getString("Role"));
                }
            }
            ps.close();
            return userAccount;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
//    public UserAccount getUserAccount(String user, String pass) {
//        
//        try {
//            UserAccount userAccount = null;
//            PreparedStatement ps = null;
//            try (Connection conn = DBcontext.connectDB()) {
//                String sql = "* FROM UserAccount WHERE (UserID = ? OR Email = ?) AND Password = ?";
//                ps = conn.prepareStatement(sql);
//                ps.setString(1, user);
//                ps.setString(2, user);
//                ps.setString(3, pass); 
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    userAccount = new UserAccount();
//                    userAccount.setUserID(rs.getString("UserID"));
//                    userAccount.setPassWord(rs.getString("Password"));
//                    userAccount.setFullName(rs.getString("FullName"));
//                    userAccount.setEmail(rs.getString("Email"));
//                    userAccount.setRole(rs.getString("Role"));
//                }
//            }
//            ps.close();
//            return userAccount;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//    
//    public UserAccount getUserBy(String user, String pass) throws SQLException {
//        String sql = "SELECT UserID, FullName, Password, Email, Role FROM UserAccount "
//                + "WHERE (UserID = 'he190177' OR Email = '') AND Password = 'duchieu1901'";
//        
//
//        Connection conn = DBcontext.connectDB();
//
//        try (PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, user);
//            ps.setString(2, user);
//            ps.setString(3, pass);
//            System.out.println(conn);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    UserAccount userAccount = new UserAccount();
//                    userAccount.setUserID(rs.getString("UserID"));
//                    userAccount.setPassWord(rs.getString("Password"));
//                    userAccount.setFullName(rs.getString("FullName"));
//                    userAccount.setEmail(rs.getString("Email"));
//                    userAccount.setRole(rs.getString("Role"));
//                    
//                    return userAccount;
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, "Lỗi truy vấn user account", ex);
//        }
//
//        return null;
//    }
    
    public UserAccount getUserAccount(String user, String pass) {
        try {
            UserAccount userAccount = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT UserID, FullName, Password, Email, Role FROM UserAccount "
                + "WHERE (UserID = ? OR Email = ?) AND Password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, user);
                ps.setString(3, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    userAccount = new UserAccount();
                    userAccount.setUserID(rs.getString("UserID"));
                    userAccount.setPassWord(rs.getString("Password"));
                    userAccount.setFullName(rs.getString("FullName"));
                    userAccount.setEmail(rs.getString("Email"));
                    userAccount.setRole(rs.getString("Role"));
                    return userAccount;
                }
            }
            ps.close();
            return userAccount;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public UserAccount getUser(String user, String pass) throws SQLException {
        String sql = "SELECT UserID, FullName, Password, Email, Role FROM UserAccount "
                + "WHERE (UserID = ? OR Email = ?) AND Password = ?";

        try (Connection conn = DBcontext.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, user); // vì dùng cả Username lẫn Email
            ps.setString(3, pass); // chú ý: nếu mật khẩu được mã hóa trong DB, cần mã hóa pass trước


            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserAccount userAccount = new UserAccount();
                    userAccount.setUserID(rs.getString("UserID"));
                    userAccount.setPassWord(rs.getString("Password"));
                    userAccount.setFullName(rs.getString("FullName"));
                    userAccount.setEmail(rs.getString("Email"));
                    userAccount.setRole(rs.getString("Role"));
                    return userAccount;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, "Lỗi truy vấn user account", ex);
        }

        return null;
    }
    
}
