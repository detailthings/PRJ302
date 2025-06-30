/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Reviewer {

    private int id;
    private String reviewerID;
    private String department;
    private String fullName;

   

    public Reviewer() {
    }

    public Reviewer(int id, String teacherID, String department, String fullname) {
        this.id = id;
        this.reviewerID = teacherID;
        this.department = department;
        this.fullName = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(String teacherID) {
        this.reviewerID = teacherID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
     public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
