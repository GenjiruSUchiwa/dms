package com.aptkode.example.firestore.data.dto;

import com.aptkode.example.firestore.data.model.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RegisterOD {
    private String definitionID;
    private String definitionName;
    private List<Field> fields;
    private long creationDate;

    public RegisterOD(String definitionID, String definitionName, Service service, List<Field>fields, long creationDate) {
        this.definitionID = definitionID;
        this.definitionName = definitionName;
        this.fields = fields;
        this.creationDate = creationDate;
    }

    public String getDefinitionID() {
        return definitionID;
    }

    public void setDefinitionID(String definitionID) {
        this.definitionID = definitionID;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName;
    }


    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }
}
