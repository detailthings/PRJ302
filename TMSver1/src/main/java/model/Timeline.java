/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author admin
 */
public class Timeline {
    
    private String id;
    private String status_1;
    private String status_2;
    private String status_3;
    private Date start_date;
    private Date end_date;

    public Timeline() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus_1() {
        return status_1;
    }

    public void setStatus_1(String status_1) {
        this.status_1 = status_1;
    }

    public String getStatus_2() {
        return status_2;
    }

    public void setStatus_2(String status_2) {
        this.status_2 = status_2;
    }

    public String getStatus_3() {
        return status_3;
    }

    public void setStatus_3(String status_3) {
        this.status_3 = status_3;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
  
}
