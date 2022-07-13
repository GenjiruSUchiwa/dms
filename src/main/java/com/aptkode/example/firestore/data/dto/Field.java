package com.aptkode.example.firestore.data.dto;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;


public class Field {
    private String key;
    private  String type;
    private int maxLength;
    private boolean sequence;
    private boolean nullable;
    private boolean unique;
    private String sequenceValue;
    private  String SequenceOrder;

    public Field() {
    }

    public Field(String key, String type, int maxLength, boolean sequence, boolean nullable, boolean unique, String sequenceValue, String sequenceOrder) {
        this.key = key;
        this.type = type;
        this.maxLength = maxLength;
        this.sequence = sequence;
        this.nullable = nullable;
        this.unique = unique;
        this.sequenceValue = sequenceValue;
        SequenceOrder = sequenceOrder;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isSequence() {
        return sequence;
    }

    public void setSequence(boolean sequence) {
        this.sequence = sequence;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public String getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(String sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public String getSequenceOrder() {
        return SequenceOrder;
    }

    public void setSequenceOrder(String sequenceOrder) {
        SequenceOrder = sequenceOrder;
    }

    @Override
    public String toString() {
        return "Field{" +
                "key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", maxLength=" + maxLength +
                ", sequence=" + sequence +
                ", nullable=" + nullable +
                ", unique=" + unique +
                ", sequenceValue='" + sequenceValue + '\'' +
                ", SequenceOrder='" + SequenceOrder + '\'' +
                '}';
    }
}
