/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Project {
    
    private String projectCode;
    private String title;
    private String description;
    private String teacherID;
    private String semesterID;
    private String judgingID;

    public Project() {
    }

    public Project(String projectCode, String title, String description, String teacherID, String semesterID, String judgingID) {
        this.projectCode = projectCode;
        this.title = title;
        this.description = description;
        this.teacherID = teacherID;
        this.semesterID = semesterID;
        this.judgingID = judgingID;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }

    public String getJudgingID() {
        return judgingID;
    }

    public void setJudgingID(String judgingID) {
        this.judgingID = judgingID;
    }
    
    
    
}
