/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBcontext {
    public static Connection connectDB() throws SQLException{
        
        try {
            // dang ky drive cho project
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao ket noi
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PRJ302;trustServerCertificate=true", "sa", "sa");
            
            System.out.println("succcessful database PRJ302");
            // ket noi thanh cong tra ve conn
           return conn;
        } catch (ClassNotFoundException | SQLException ex) {
        }
 
        return null;
    }
    public static void main(String[] args) throws SQLException {
        DBcontext.connectDB();
    }
}
