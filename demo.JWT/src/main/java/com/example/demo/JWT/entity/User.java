package com.example.demo.JWT.entity;

import com.example.demo.JWT.common.Constant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String gender;
    private String emailId;
    private String phoneNumber;
    private String userType = Constant.USER_Type.NORMAL;
    private String password;
    private Boolean isActive = true;
    private Integer loginCount = 0;
    private String ssoType;
    private Timestamp loginAt;
    private Timestamp createdAt;
    private  Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getSsoType() {
        return ssoType;
    }

    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }

    public Timestamp getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Timestamp loginAt) {
        this.loginAt = loginAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onSave(){
        //created at and updated at

        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PostPersist
    public void onUpdate(){
        //updated at

        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
