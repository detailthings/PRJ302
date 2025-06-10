/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Judging {
    
    private String id;
    private String projectCode;
    private String teacherID;
    private String reviewer1ID;
    private String reviewer2ID;

    public Judging() {
    }

    public Judging(String id, String projectCode, String teacherID, String reviewer1ID, String reviewer2ID) {
        this.id = id;
        this.projectCode = projectCode;
        this.teacherID = teacherID;
        this.reviewer1ID = reviewer1ID;
        this.reviewer2ID = reviewer2ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getReviewer1ID() {
        return reviewer1ID;
    }

    public void setReviewer1ID(String reviewer1ID) {
        this.reviewer1ID = reviewer1ID;
    }

    public String getReviewer2ID() {
        return reviewer2ID;
    }

    public void setReviewer2ID(String reviewer2ID) {
        this.reviewer2ID = reviewer2ID;
    }
    
    
    
}
