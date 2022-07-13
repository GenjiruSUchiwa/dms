package com.aptkode.example.firestore.data.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.List;
import java.util.Objects;

@Document(collectionName = "Tenants")
public class Tenant {
    @DocumentId
    private String tetantId;
    private String tenantName;
    private List<Service> subscribedServices;
   private List<User> members;
   private List<Subscription> subscriptions;

    public Tenant(String tetantId, String tenantName, List<Service> subscribedServices, List<User> members, List<Subscription> subscriptions) {
        this.tetantId = tetantId;
        this.tenantName = tenantName;
        this.subscribedServices = subscribedServices;
        this.members = members;
        this.subscriptions = subscriptions;
    }

    public Tenant(String tetantId, String tenantName) {
        this.tetantId = tetantId;
        this.tenantName = tenantName;
    }

    public Tenant() {
    }

    public String getTetantId() {
        return tetantId;
    }

    public void setTetantId(String tetantId) {
        this.tetantId = tetantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public List<Service> getSubscribedServices() {
        return subscribedServices;
    }

    public void setSubscribedServices(List<Service> subscribedServices) {
        this.subscribedServices = subscribedServices;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenant)) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(getTetantId(), tenant.getTetantId()) && Objects.equals(getTenantName(), tenant.getTenantName()) && Objects.equals(getSubscribedServices(), tenant.getSubscribedServices()) && Objects.equals(getMembers(), tenant.getMembers()) && Objects.equals(getSubscriptions(), tenant.getSubscriptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTetantId(), getTenantName(), getSubscribedServices(), getMembers(), getSubscriptions());
    }
}
