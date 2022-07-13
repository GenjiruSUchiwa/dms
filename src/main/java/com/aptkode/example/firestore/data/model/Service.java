package com.aptkode.example.firestore.data.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
@Document(collectionName = "Services")
public class Service {
    @DocumentId
    private String serviceId;
    private String serviceName;
    private String baseUrl;
    private String deployedVersion;
    private Date lastDeployedDate;
    private List<ObjectDefinition> objectDefinitions;

    public Service() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Service(String serviceName, String serviceId, String baseUrl, String deployedVersion, Date lastDeployedDate) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.baseUrl = baseUrl;
        this.deployedVersion = deployedVersion;
        this.lastDeployedDate = lastDeployedDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getDeployedVersion() {
        return deployedVersion;
    }

    public void setDeployedVersion(String deployedVersion) {
        this.deployedVersion = deployedVersion;
    }

    public Date getLastDeployedDate() {
        return lastDeployedDate;
    }

    public void setLastDeployedDate(Date lastDeployedDate) {
        this.lastDeployedDate = lastDeployedDate;
    }

    public List<ObjectDefinition> getObjectDefinitions() {
        return objectDefinitions;
    }

    public void setObjectDefinitions(List<ObjectDefinition> objectDefinitions) {
        this.objectDefinitions = objectDefinitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(getServiceName(), service.getServiceName()) && Objects.equals(getServiceId(), service.getServiceId()) && Objects.equals(getBaseUrl(), service.getBaseUrl()) && Objects.equals(getDeployedVersion(), service.getDeployedVersion()) && Objects.equals(getLastDeployedDate(), service.getLastDeployedDate()) && Objects.equals(getObjectDefinitions(), service.getObjectDefinitions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceName(), getServiceId(), getBaseUrl(), getDeployedVersion(), getLastDeployedDate(), getObjectDefinitions());
    }
}
