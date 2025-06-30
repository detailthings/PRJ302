/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.sql.Timestamp;

/**
 *
 * @author admin
 */
@Entity
public class Submission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String projectID;
    private int deliverableID;
    private Timestamp submissionDate;
    private Timestamp lastModified;
    private String status;

    public Submission() {
    }

    public Submission(int id, String projectID, int deliverableID, Timestamp submissionDate, Timestamp lastModified, String status) {
        this.id = id;
        this.projectID = projectID;
        this.deliverableID = deliverableID;
        this.submissionDate = submissionDate;
        this.lastModified = lastModified;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public int getDeliverableID() {
        return deliverableID;
    }

    public void setDeliverableID(int deliverableID) {
        this.deliverableID = deliverableID;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
