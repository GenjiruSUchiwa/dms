package com.aptkode.example.firestore.data.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.Map;
import java.util.Objects;
@Document(collectionName = "ObjectInstances")
public class ObjectInstance {
    @DocumentId
    private String instanceID;
    private ObjectDefinition Definition;
    private Map<String,String> fields;
    private Map<String,String> customFields;

    public ObjectInstance() {
    }

    public ObjectInstance(ObjectDefinition definition, Map<String, String> fields, Map<String, String> customFields) {
        Definition = definition;
        this.fields = fields;
        this.customFields = customFields;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    public ObjectDefinition getDefinition() {
        return Definition;
    }

    public void setDefinition(ObjectDefinition definition) {
        Definition = definition;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public Map<String, String> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(Map<String, String> customFields) {
        this.customFields = customFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectInstance)) return false;
        ObjectInstance that = (ObjectInstance) o;
        return Objects.equals(getInstanceID(), that.getInstanceID()) && Objects.equals(getDefinition(), that.getDefinition()) && Objects.equals(getFields(), that.getFields()) && Objects.equals(getCustomFields(), that.getCustomFields());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstanceID(), getDefinition(), getFields(), getCustomFields());
    }
}
