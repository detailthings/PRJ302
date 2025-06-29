/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author admin
 */

@Entity
public class Deliverable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int deliverableID;
    private String title;
    private String description;
    private float weighting;
    private Date submissionOpenDate;
    private Date dueDate;

    public Deliverable() {
    }

    public Deliverable(int deliverableID, String title, String description, float weighting, Date submissionOpenDate, Date dueDate) {
        this.deliverableID = deliverableID;
        this.title = title;
        this.description = description;
        this.weighting = weighting;
        this.submissionOpenDate = submissionOpenDate;
        this.dueDate = dueDate;
    }

    public int getDeliverableID() {
        return deliverableID;
    }

    public void setDeliverableID(int deliverableID) {
        this.deliverableID = deliverableID;
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

    public float getWeighting() {
        return weighting;
    }

    public void setWeighting(float weighting) {
        this.weighting = weighting;
    }

    public Date getSubmissionOpenDate() {
        return submissionOpenDate;
    }

    public void setSubmissionOpenDate(Date submissionOpenDate) {
        this.submissionOpenDate = submissionOpenDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    
    
    
}
