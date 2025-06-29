/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;


/**
 *
 * @author admin
 */

@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String projectID;
    private String title;
    private String description;
    private String teacherID;
    private String semesterID;
    private String judgingID;
    private String studentID;
    private Float scorce;

    public Project() {
    }

    public Project(String projectID, String title, String description, String teacherID, String semesterID, String judgingID, String studentID) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.teacherID = teacherID;
        this.semesterID = semesterID;
        this.judgingID = judgingID;
    }

    public Project(String projectID, String title, String description, String teacherID, String semesterID, String judgingID, String studentID, Float scorce) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.teacherID = teacherID;
        this.semesterID = semesterID;
        this.judgingID = judgingID;
        this.studentID = studentID;
        this.scorce = scorce;
    }
    
    public String getProjectCode() {
        return projectID;
    }

    public void setProjectCode(String projectID) {
        this.projectID = projectID;
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

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Float getScorce() {
        return scorce;
    }

    public void setScorce(Float scorce) {
        this.scorce = scorce;
    }

}
