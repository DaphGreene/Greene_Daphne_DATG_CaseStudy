package com.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name="user")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email(message = "Enter valid email address.")
    @NotEmpty(message = "This field must not be left empty.")
    private String email;

    @NotEmpty
    @Length(min = 2)
    @Length(max = 20)
    @Pattern(regexp="[^\\s]+", message = "User name can not include spaces")
    private String username;

    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$")
    @Length(min = 8, message = "Can't leave blank, must be minimum of 8 characters including one lowercase, one uppercase, one number, and one special character.")
    private String password;

    @Size(max = 40, message = "Enter at least 40 characters please.")
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

    public UserInfo(Integer id, String email, String username, String password, String description, Date targetDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.description = description;
        this.targetDate = targetDate;
    }

    // public UserInfo(String username, String description, Date targetDate) {
    //     this.username = username;
    //     this.description = description;
    //     this.targetDate = targetDate;
    // }

    //Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    //Password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //TargetDate
    public Date getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
