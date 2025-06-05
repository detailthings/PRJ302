/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
//import java.sql.*;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author king
 */
public class DBconnect {
    public static Connection connectDB() throws SQLException{
        
        try {
            // dang ky drive cho project
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao ket noi
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLDA3;trustServerCertificate=true", "sa", "123");
            
            System.out.println("succcessful");
            // ket noi thanh cong tra ve conn
           return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return null;
    }
    public static void main(String[] args) throws SQLException {
        DBconnect.connectDB();
    }
}