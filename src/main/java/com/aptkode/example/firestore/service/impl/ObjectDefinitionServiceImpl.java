package com.aptkode.example.firestore.service.impl;

import com.aptkode.example.firestore.FirestoreApplication;
import com.aptkode.example.firestore.data.dto.Field;
import com.aptkode.example.firestore.data.dto.RegisterOD;
import com.aptkode.example.firestore.data.model.ObjectDefinition;
import com.aptkode.example.firestore.data.model.StatusEnum;
import com.aptkode.example.firestore.data.model.User;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.service.api.ObjectDefinitionServiceApi;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class ObjectDefinitionServiceImpl implements ObjectDefinitionServiceApi {
    @Autowired
    private Firestore firestore;
    private final static Logger logger = LoggerFactory.getLogger(FirestoreApplication.class);

    @Override
    public GenericApiResponse<ObjectDefinition> saveObjectDefinition(RegisterOD request, String service, String accessToken) throws ExecutionException, InterruptedException {
        try {
            com.aptkode.example.firestore.data.model.Service service1 = readDocument(service);
            if (service1 != null) {
                ObjectDefinition objectDefinitionToCreate = new ObjectDefinition(UUID.randomUUID().toString(), request.getDefinitionName(), request.getFields(), new Date(request.getCreationDate()));
                ApiFuture<WriteResult> apiFuture = this.firestore.collection("services")
                        .document(service)
                        .collection("objectDefinitions")
                        .document(objectDefinitionToCreate.getDefinitionID())
                        .set(objectDefinitionToCreate);
                WriteResult writeResult = apiFuture.get();
                logger.info("Update time: {}", writeResult.getUpdateTime());
                return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, objectDefinitionToCreate);
            } else {
                return new GenericApiResponse(StatusEnum.FAILED.name(), "No service found with the following id: " + service, "", 400, null);
            }

        } catch (Exception e) {
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", e.getStackTrace().toString(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<ObjectDefinition> updateObjectDefinition(RegisterOD request, String service, String accessToken) throws ExecutionException, InterruptedException {

        try {
            logger.info("starting to delete object definition: " + request);
            com.aptkode.example.firestore.data.model.Service service1 = readDocument(service);
            if (service1 != null) {
                ObjectDefinition objectDefinitionToCreate = new ObjectDefinition(request.getDefinitionID(), request.getDefinitionName(), request.getFields(), new Date(request.getCreationDate()));
                ApiFuture<WriteResult> apiFuture = this.firestore.collection("services")
                        .document(service)
                        .collection("objectDefinitions")
                        .document(objectDefinitionToCreate.getDefinitionID())
                        .set(objectDefinitionToCreate);
                WriteResult writeResult = apiFuture.get();
                logger.info("updated object definition: " + request);
                return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, objectDefinitionToCreate);
            } else {
                logger.warn("No service found with the following id: " + service);
                return new GenericApiResponse(StatusEnum.FAILED.name(), "No service found with the following id: " + service, "", 400, null);
            }

        } catch (Exception e) {
            logger.warn("failed to read object definition: " + "failed to update user", e.getStackTrace().toString());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", e.getMessage() + " and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<ObjectDefinition> updateObjectDefinition(Field field, String serviceId, String objectDefinitionId, String userAcceccToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("starting to updating object definition: " + field);
            com.aptkode.example.firestore.data.model.Service service1 = readDocument(serviceId);
            if (service1 != null) {
                ApiFuture<DocumentSnapshot> apiFuture = this.firestore.collection("services")
                        .document(serviceId)
                        .collection("objectDefinitions")
                        .document(objectDefinitionId)
                        .get();
                DocumentSnapshot documentSnapshot = apiFuture.get();
                ObjectDefinition response = documentSnapshot.toObject(ObjectDefinition.class);
                logger.info("got object definition: " + response);
                logger.info("updating object definition with field: " + field);
                List<Field> fields = response.getFields();

                if (response.getFields() == null ) {
                    fields = new ArrayList<Field>();
                    fields.add(field);

                } else {
                    logger.info("final list of fields" + fields);
                    if(fields.isEmpty()){
                        fields.add(field);
                    }else {
                        boolean updated = false;
                        for (int i = 0; i < fields.size(); i++) {
                            logger.info("looking for field in the list of field with field: " + field);
                            if (field.getKey().equalsIgnoreCase(fields.get(i).getKey())) {
                                logger.info("found object definition at position: " + i);
                                fields.set(i, field);
                                updated = true;
                            }
                        }
                        if (!updated) {
                            fields.add(field);
                        }
                    }

                }


                response.setFields(fields);

                ApiFuture<WriteResult> apiFutureFinal = this.firestore.collection("services")
                        .document(serviceId)
                        .collection("objectDefinitions")
                        .document(objectDefinitionId)
                        .set(response);
                logger.info("updated object definition: " + response);
                return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, response);
            } else {
                logger.warn("No service found with the following id: " + serviceId);
                return new GenericApiResponse(StatusEnum.FAILED.name(), "No service found with the following id: " + serviceId, "", 400, null);
            }

        } catch (Exception e) {
            logger.warn("failed to read object definition: " + "failed to update user", e.getStackTrace().toString());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", e.getMessage() + " and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<ObjectDefinition> updateObjectDefinition(String fieldName, String serviceId, String objectDefinitionId, String userAcceccToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("starting to delete object definition field: " + fieldName);
            com.aptkode.example.firestore.data.model.Service service1 = readDocument(serviceId);
            if (service1 != null) {
                ApiFuture<DocumentSnapshot> apiFuture = this.firestore.collection("services")
                        .document(serviceId)
                        .collection("objectDefinitions")
                        .document(objectDefinitionId)
                        .get();
                DocumentSnapshot documentSnapshot = apiFuture.get();
                ObjectDefinition response = documentSnapshot.toObject(ObjectDefinition.class);
                logger.info("got object definition: " + response);
                logger.info("ulooking for field name : " + fieldName);
                List<Field> fields = response.getFields();

                if (response.getFields() == null ) {
                    fields = new ArrayList<Field>();
                    return new GenericApiResponse(StatusEnum.SUCCESS.name(), "field not found", null, 301, response);

                } else {
                    logger.info("final list of fields" + fields);
                    if(fields.isEmpty()){
                        return new GenericApiResponse(StatusEnum.SUCCESS.name(), "field not found", null, 301, response);
                    }else {
                        boolean updated = false;
                        for (int i = 0; i < fields.size(); i++) {
                            logger.info("looking for field in the list of field with field: " + fieldName);
                            if (fieldName.equalsIgnoreCase(fields.get(i).getKey())) {
                                logger.info("found object definition at position: " + i);
                                fields.remove(i);
                                updated = true;
                            }
                        }
                        if (!updated) {
                            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "field not found", null, 301, response);
                        }
                    }
                    logger.info("fieldls "+fields.size());
                    response.setFields(fields);

                }




                ApiFuture<WriteResult> apiFutureFinal = this.firestore.collection("services")
                        .document(serviceId)
                        .collection("objectDefinitions")
                        .document(objectDefinitionId)
                        .set(response);
                logger.info("updated object definition: " + response);
                return new GenericApiResponse(StatusEnum.SUCCESS.name(), "field deleted with field name", null, 200, response);
            } else {
                logger.warn("No service found with the following id: " + serviceId);
                return new GenericApiResponse(StatusEnum.FAILED.name(), "No service found with the following id: " + serviceId, "", 400, null);
            }

        } catch (Exception e) {
            logger.warn("failed to read object definition: " + "failed to update user", e.getStackTrace().toString());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", e.getMessage() + " and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<ObjectDefinition> readObjectDefinition(String objectID, String service, String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("starting to read object definition: " + objectID + " and service Id " + service);
            ObjectDefinition objectDefinition = readObjectDefinition(objectID, service);
            logger.info("read object definition: " + objectDefinition);
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, objectDefinition);

        } catch (Exception e) {
            logger.info("failed to read object definition: " + objectID + e.getStackTrace().toString());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to read object definition ", e.getMessage() + " and " + e.getLocalizedMessage(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<ObjectDefinition> deleteObjectDefinition(String request, String service, String accessToken) throws ExecutionException, InterruptedException {
        try {
            logger.info("starting to delete object definition: " + request);
            ApiFuture<WriteResult> apiFuture = this.firestore.document("services/" + service + "/" + "objectDefinitions/" + request).delete();
            WriteResult writeResult = apiFuture.get();
            logger.info("Deleted object definition : " + "services/" + service + "/" + "objectDefinitions/" + request);
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "object definition successfully deleted", null, 200, new ObjectDefinition());
        } catch (Exception e) {
            logger.warn("failed to delete object definition " + "services/" + service + "/" + "objectDefinitions/" + request + "causes: " + e.getStackTrace());
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to delete object definition", e.getMessage() + "and " + e.getLocalizedMessage(), 500, null);
        }
    }

    public com.aptkode.example.firestore.data.model.Service readDocument(String userId) throws ExecutionException, InterruptedException {
        logger.info("Getting the service with the id " + userId);
        // you could reference document by this.firestore.collection("users").document("tom") as well
        ApiFuture<DocumentSnapshot> apiFuture = this.firestore.document("services/" + userId).get();

        // .get() blocks on response
        DocumentSnapshot documentSnapshot = apiFuture.get();

        com.aptkode.example.firestore.data.model.Service response = documentSnapshot.toObject(com.aptkode.example.firestore.data.model.Service.class);
        logger.info("Service successfully got from firebase " + userId);
        return response;
    }

    public ObjectDefinition readObjectDefinition(String object, String service) throws ExecutionException, InterruptedException {
        logger.info("Getting the service with the id " + service);
        // you could reference document by this.firestore.collection("users").document("tom") as well
        ApiFuture<DocumentSnapshot> apiFuture = this.firestore.collection("services")
                .document(service)
                .collection("objectDefinitions")
                .document(object).get();

        // .get() blocks on response
        DocumentSnapshot documentSnapshot = apiFuture.get();
        ObjectDefinition response = documentSnapshot.toObject(ObjectDefinition.class);
        logger.info("object definition successfully got from firebase " + response);
        return response;
    }
}
