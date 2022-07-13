package com.aptkode.example.firestore.service.impl;

import com.aptkode.example.firestore.data.model.ObjectDefinition;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterServicePOJO;
import com.aptkode.example.firestore.data.model.StatusEnum;
import com.aptkode.example.firestore.service.api.ServiceServiceApi;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


@Service
public class ServiceServiceImpl implements ServiceServiceApi {
    @Autowired
    private Firestore firestore;

    private final static Logger logger = LoggerFactory.getLogger(ServiceServiceApi.class);

    @Override
    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> createServer(RegisterServicePOJO request) throws ExecutionException, InterruptedException {
        com.aptkode.example.firestore.data.model.Service serviceToCreate = new com.aptkode.example.firestore.data.model.Service(request.getServiceName(), UUID.randomUUID().toString(), request.getBaseUrl(), request.getDeployedVersion(), request.getLastDeployedDate());
        ApiFuture<WriteResult> apiFuture = this.firestore.collection("services").document(UUID.randomUUID().toString()).set(serviceToCreate);
        WriteResult writeResult = apiFuture.get();
        logger.info("Update time: {}", writeResult.getUpdateTime());
        return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, serviceToCreate);
    }

    @Override
    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> updateServer(RegisterServicePOJO request, String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("Starting to update service ... ", request.toString());
            com.aptkode.example.firestore.data.model.Service serviceToCreate = new com.aptkode.example.firestore.data.model.Service(request.getServiceName(), request.getServiceId(), request.getBaseUrl(), request.getDeployedVersion(), request.getLastDeployedDate());
            ApiFuture<WriteResult> apiFuture = this.firestore.collection("services").document(serviceToCreate.getServiceId()).set(serviceToCreate);
            WriteResult writeResult = apiFuture.get();
            logger.info("service update successfully", serviceToCreate);
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, serviceToCreate);
        } catch (Exception e) {
            logger.warn("failed to update the service", e.getStackTrace());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to delete object definition", e.getMessage() + "and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> readService(String request, String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("Getting the service with the id " + request);
            // you could reference document by this.firestore.collection("users").document("tom") as well
            ApiFuture<DocumentSnapshot> apiFuture = this.firestore.document("services/" + request).get();
            // .get() blocks on response
            DocumentSnapshot documentSnapshot = apiFuture.get();
            com.aptkode.example.firestore.data.model.Service response = documentSnapshot.toObject(com.aptkode.example.firestore.data.model.Service.class);
            Map<String, Object> originalResponse = documentSnapshot.getData();
            ApiFuture<QuerySnapshot> objects = this.firestore.collection("services/" + request + "/objectDefinitions").get();
            QuerySnapshot objectDefinitions = objects.get();
            List<ObjectDefinition> objectDefinitionList = objectDefinitions.toObjects(ObjectDefinition.class);
            logger.info("Service successfully got from firebase " + originalResponse.toString());
            response.setObjectDefinitions(objectDefinitionList);
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "Service successfully got from database", null, 200, response);
        } catch (Exception e) {
            logger.warn("failed to update the service", e.getStackTrace());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to get Service from firebase", e.getMessage() + "and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> deleteService(String request, String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("starting to delete service: " + request);
            ApiFuture<WriteResult> apiFuture = this.firestore.document("services/" + request).delete();
            WriteResult writeResult = apiFuture.get();
            logger.info("Deleted service : " + "services/" + request);
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "object definition successfully deleted", null, 200, new ObjectDefinition());

        } catch (Exception e) {
            logger.warn("failed to delete service " + request + "causes: " + e.getStackTrace());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to delete object definition", e.getMessage() + "and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<List<com.aptkode.example.firestore.data.model.Service>> getAllServices(String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("Getting the service with the id " + accessToken);
            // you could reference document by this.firestore.collection("users").document("tom") as well
            ApiFuture<QuerySnapshot> apiFuture = this.firestore.collection("services").get();
            // .get() blocks on response
            QuerySnapshot documentSnapshot = apiFuture.get();

            List<com.aptkode.example.firestore.data.model.Service> response = documentSnapshot.toObjects(com.aptkode.example.firestore.data.model.Service.class);
            for (com.aptkode.example.firestore.data.model.Service service : response
            ) {
                ApiFuture<QuerySnapshot> apiFuture2 = this.firestore.collection("services/"+service.getServiceId()+"/objectDefinitions").get();
                QuerySnapshot documentSnapshot2 = apiFuture2.get();
                List<ObjectDefinition> objectDefinitions=documentSnapshot2.toObjects(ObjectDefinition.class);
                service.setObjectDefinitions(objectDefinitions);
            }
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "Service successfully got from database", null, 200, response);
        } catch (Exception e) {
            logger.warn("failed to update the service", e.getStackTrace());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to get Service from firebase", e.getMessage() + "and " + e.getLocalizedMessage(), 500, null);
        }
    }
}
