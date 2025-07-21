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
    
    
    private int submissionID;
    @ManyToOne
    @JoinColumn(name = "projectID")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "deliverableID", referencedColumnName = "deliverableID", insertable = false, updatable = false)
    private Deliverable deliverable;
    private Timestamp submissionDate;
    private Timestamp lastModified;
    private String status;
    private String path;

    public Submission() {
    }

    public Submission(int submissionID, Project project, Deliverable deliverable, Timestamp submissionDate, Timestamp lastModified, String status) {
        this.submissionID = submissionID;
        this.project = project;
        this.deliverable = deliverable;
        this.submissionDate = submissionDate;
        this.lastModified = lastModified;
        this.status = status;
    }

    public Submission(int submissionID, Project project, Deliverable deliverable, Timestamp submissionDate, Timestamp lastModified, String status, String path) {
        this.submissionID = submissionID;
        this.project = project;
        this.deliverable = deliverable;
        this.submissionDate = submissionDate;
        this.lastModified = lastModified;
        this.status = status;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Deliverable getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Deliverable deliverable) {
        this.deliverable = deliverable;
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
