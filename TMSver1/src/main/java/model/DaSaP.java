/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class DaSaP {
    private Deliverable deliverable;
    private Submission submission;
    private Project project;

    public DaSaP(Deliverable deliverable, Submission submission) {
        this.deliverable = deliverable;
        this.submission = submission;
    }

    public DaSaP(Deliverable deliverable, Submission submission, Project project) {
        this.deliverable = deliverable;
        this.submission = submission;
        this.project = project;
    }

    public Deliverable getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Deliverable deliverable) {
        this.deliverable = deliverable;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    
}
