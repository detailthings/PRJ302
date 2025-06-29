/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author admin
 */
@Entity
public class Semester {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String semesterID;
    private String semester;
    private int year;
    private Date startDate;
    private Date endDate;

    public Semester() {
    }

    public Semester(String semesterID, String semester, int year, Date startDate, Date endDate) {
        this.semesterID = semesterID;
        this.semester = semester;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
}
