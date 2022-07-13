package com.aptkode.example.firestore.data.dto;

import com.google.cloud.firestore.annotation.DocumentId;

import java.util.Date;

public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private long doB;
    private String photo;
    private String accessKey;
    private String gender;

    public RegisterUserRequest(String firstName, String lastName, long doB, String photo, String accessKey,String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.photo = photo;
        this.accessKey = accessKey;
        this.gender= gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getDoB() {
        return doB;
    }

    public void setDoB(long doB) {
        this.doB = doB;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
