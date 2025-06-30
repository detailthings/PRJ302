/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

/**
 *
 * @author admin
 */

@Entity
public class Reviewer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String id;
    private String reviewerID;
    private String department;

    public Reviewer() {
    }

    public Reviewer(String id, String teacherID, String department) {
        this.id = id;
        this.reviewerID = teacherID;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    
}
