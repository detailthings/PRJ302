/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Deliverable {
    
    private int id;
    private String title;
    private String description;
    private float weighting;
    private String submissionOpenDate;
    private String dueDate;

    public Deliverable() {
    }

    public Deliverable(int id, String title, String description, float weighting, String submissionOpenDate, String dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.weighting = weighting;
        this.submissionOpenDate = submissionOpenDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSubmissionOpenDate() {
        return submissionOpenDate;
    }

    public void setSubmissionOpenDate(String submissionOpenDate) {
        this.submissionOpenDate = submissionOpenDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    
    
}
