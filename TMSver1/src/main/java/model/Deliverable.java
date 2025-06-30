/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date; 

/**
 *
 * @author admin
 */
public class Deliverable {
    
    private int id;
    private String title;
    private String description;
    private float weighting;
    private Date submissionOpenDate;
    private Date dueDate;

    public Deliverable(int id1, String title1, String department, float weighting1, String department1, String department2) {
    }

    public Deliverable(int id, String title, String description, float weighting, Date submissionOpenDate, Date dueDate) {
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

    @Override
    public String toString() {
        return "Deliverable{" + "id=" + id + ", title=" + title + ", description=" + description + ", weighting=" + weighting + ", submissionOpenDate=" + submissionOpenDate + ", dueDate=" + dueDate + '}';
    }

    
    
    
    
}
