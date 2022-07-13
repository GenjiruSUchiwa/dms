package com.aptkode.example.firestore.data.model;

import com.aptkode.example.firestore.data.dto.Field;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document(collectionName = "objectDefinitions")
public class ObjectDefinition {
    @DocumentId
    private String definitionID;
    private String definitionName;
    private List<Field> fields;
    private Date creationDate;



    public ObjectDefinition(String definitionID, String definitionName, List<Field> fields, Date creationDate) {
        this.definitionID = definitionID;
        this.definitionName = definitionName;
        this.fields = fields;
        this.creationDate = creationDate;
    }

    public ObjectDefinition() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ObjectDefinition{" +
                "definitionID='" + definitionID + '\'' +
                ", definitionName='" + definitionName + '\'' +
                ", fields=" + fields +
                ", creationDate=" + creationDate +
                '}';
    }
}
