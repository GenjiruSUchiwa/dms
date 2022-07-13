package com.aptkode.example.firestore.data.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.Objects;

@Document(collectionName = "Roles")
public class Role {
    private String roleName;
    private String roleValue;
    @DocumentId
    private String roleID;

    public Role(String roleName, String roleValue, String roleID) {
        this.roleName = roleName;
        this.roleValue = roleValue;
        this.roleID = roleID;
    }

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getRoleName(), role.getRoleName()) && Objects.equals(getRoleValue(), role.getRoleValue()) && Objects.equals(getRoleID(), role.getRoleID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName(), getRoleValue(), getRoleID());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", roleID='" + roleID + '\'' +
                '}';
    }
}
