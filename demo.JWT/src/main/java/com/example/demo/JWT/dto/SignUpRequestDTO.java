package com.example.demo.JWT.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SignUpRequestDTO {

    @NotEmpty
    @Size(min = 3, message = "User name should have atleast 3 characters")
    private String name;

    @NotEmpty
    private String gender;

    @NotEmpty
    @Pattern(regexp="^(.+)@(\\S+)$", message = "must be a well-formed email address")
    @Email
    private String emailId;

    @NotEmpty
    @Pattern(regexp="(^$|[0-9]{10})", message = "must contain 10 digits")
    private String phoneNumber;

    @NotEmpty
//    @Pattern(regexp="(^$|[0-9][A-Z][a-z]{10})")
    @Size(min = 8, message = "password should have atleast 8 characters")
    private String password;

    private String userType;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
