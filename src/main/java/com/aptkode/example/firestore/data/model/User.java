package com.aptkode.example.firestore.data.model;

import com.aptkode.example.firestore.Gender;
import com.aptkode.example.firestore.data.model.Role;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.Date;
import java.util.List;

@Document(collectionName = "users")
public class User {
    @DocumentId
    private String userId;
    private String firstName;
    private String lastName;
    private Date doB;
    private String photo;
    private String accessKey;
    private Gender gender;
    private List<Role> roles;

    public User() {
    }

    public User(String firstName,String lastName, Date age, Gender gender,String photo, String accessKey) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.doB = age;
        this.gender = gender;
        this.accessKey=accessKey;
        this.photo=photo;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
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

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public Date getAge() {
        return doB;
    }

    public void setAge(Date age) {
        this.doB = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                ", age=" + doB +
                ", gender=" + gender +
                ", interests=" + roles +
                '}';
    }
}
