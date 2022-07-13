package com.aptkode.example.firestore.data.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.Date;
import java.util.Objects;
@Document(collectionName = "Subscriptions")
public class Subscription {
    @DocumentId
    private String subscriptionId;
    private String subscriptionName;
    private String productName;
    private String tenantName;
    private Date orderDate;
    private Date expiryDate;

    public Subscription(String subscriptionId, String subscriptionName, String productName, String tenantName, Date orderDate, Date expiryDate) {
        this.subscriptionId = subscriptionId;
        this.subscriptionName = subscriptionName;
        this.productName = productName;
        this.tenantName = tenantName;
        this.orderDate = orderDate;
        this.expiryDate = expiryDate;
    }

    public Subscription() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(getSubscriptionId(), that.getSubscriptionId()) && Objects.equals(getSubscriptionName(), that.getSubscriptionName()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getTenantName(), that.getTenantName()) && Objects.equals(getOrderDate(), that.getOrderDate()) && Objects.equals(getExpiryDate(), that.getExpiryDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubscriptionId(), getSubscriptionName(), getProductName(), getTenantName(), getOrderDate(), getExpiryDate());
    }
}
