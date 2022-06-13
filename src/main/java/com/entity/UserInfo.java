package com.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="user")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @Size(min=15, message = "Enter at least 15 characters please.")
    private String description;

    private Date targetDate;

    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserInfo() {
    }

    public UserInfo(Integer id, String username, String description, Date targetDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
    }

    public UserInfo(String username, String description, Date targetDate) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
