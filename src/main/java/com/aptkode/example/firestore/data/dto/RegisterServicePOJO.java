package com.aptkode.example.firestore.data.dto;

import java.util.Date;

public class RegisterServicePOJO {
    private String serviceName;
    private String serviceId;
    private String baseUrl;
    private String deployedVersion;
    private long lastDeployedDate;

    public RegisterServicePOJO(String serviceName, String serviceId, String baseUrl, String deployedVersion, long lastDeployedDate) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.baseUrl = baseUrl;
        this.deployedVersion = deployedVersion;
        this.lastDeployedDate = lastDeployedDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
        return new Date(this.lastDeployedDate);
    }

    public void setLastDeployedDate(long lastDeployedDate) {
        this.lastDeployedDate = lastDeployedDate;
    }
}
