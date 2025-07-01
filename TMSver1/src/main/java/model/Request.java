/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author admin
 */

@Entity
public class Request {
    
    @Id
    private String id; //
    private String studentID;
    @Column(name = "title", columnDefinition = "NVARCHAR(255)")
    private String title; //
    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description; //
    private String status;
    private String teacherID; //
    private LocalDateTime createdAt;

    public Request() {
    }

    public Request(String id, String studentID, String title, String description, String status, String teacherID, LocalDateTime createdAt) {
        this.id = id;
        this.studentID = studentID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.teacherID = teacherID;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public LocalDateTime getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createdAt = createAt;
    }

    
    
}
