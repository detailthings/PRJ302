/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;

/**
 *
 * @author admin
 */
public class ProjectDAO extends DAO<Project> {

    @Override
    public int create(Project t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "INSERT INTO Project(ProjectID, Title, Description, TeacherID, SemesterID, JudgingID) VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getProjectCode());
                ps.setString(2, t.getTitle());
                ps.setString(3, t.getDescription());
                ps.setString(4, t.getTeacherID());
                ps.setString(5, t.getSemesterID());
                ps.setString(6, t.getJudgingID());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Project t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "UPDATE Project SET Title=?, Description=?, TeacherID=?, SemesterID=?, JudgingID=? WHERE ProjectID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getTitle());
                ps.setString(2, t.getDescription());
                ps.setString(3, t.getTeacherID());
                ps.setString(4, t.getSemesterID());
                ps.setString(5, t.getJudgingID());
                ps.setString(6, t.getProjectCode());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Project t) {
        try {
            int rows;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "DELETE FROM Project WHERE ProjectID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.getProjectCode());
                rows = ps.executeUpdate();
            }
            ps.close();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Project> readAll() {
        try {
            List<Project> newList;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                newList = new ArrayList<>();
                String sql = "SELECT * FROM Project";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String projectID = rs.getString("ProjectID");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    String teacherID = rs.getString("TeacherID");
                    String semesterID = rs.getString("SemesterID");
                    String judgingID = rs.getString("JudgingID");
                    newList.add(new Project(projectID, title, description, teacherID, semesterID, judgingID));
                }
            }
            ps.close();
            return newList;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Project readOnly(String projectID) {
        try {
            Project project = null;
            PreparedStatement ps;
            try (Connection conn = DBcontext.connectDB()) {
                String sql = "SELECT * FROM Project WHERE ProjectID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, projectID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    project = new Project();
                    project.setProjectCode(rs.getString("ProjectID"));
                    project.setTitle(rs.getString("Title"));
                    project.setDescription(rs.getString("Description"));
                    project.setTeacherID(rs.getString("TeacherID"));
                    project.setSemesterID(rs.getString("SemesterID"));
                    project.setJudgingID(rs.getString("JudgingID"));
                }
            }
            ps.close();
            return project;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
