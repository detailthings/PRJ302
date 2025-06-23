/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Submission {
    
    private int id;
    private String projectID;
    private int deliverableID;
    private String submissionDate;
    private String lastModified;
    private String status;

    public Submission() {
    }

    public Submission(int id, String projectID, int deliverableID, String submissionDate, String lastModified, String status) {
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

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
