package com.aptkode.example.firestore.service.api;

import com.aptkode.example.firestore.data.dto.Field;
import com.aptkode.example.firestore.data.dto.RegisterOD;
import com.aptkode.example.firestore.data.model.ObjectDefinition;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Service
public interface ObjectDefinitionServiceApi {
    public GenericApiResponse<ObjectDefinition> saveObjectDefinition(RegisterOD request, String service, String accessToken) throws ExecutionException, InterruptedException;

    public GenericApiResponse<ObjectDefinition> updateObjectDefinition(RegisterOD request, String service, String accessToken) throws ExecutionException, InterruptedException;
    public GenericApiResponse<ObjectDefinition> updateObjectDefinition( Field registerOD, String serviceId, String objectDefinitionId, String userAcceccToken) throws ExecutionException, InterruptedException;
    public GenericApiResponse<ObjectDefinition> updateObjectDefinition( String fieldName, String serviceId, String objectDefinitionId, String userAcceccToken) throws ExecutionException, InterruptedException;
    public GenericApiResponse<ObjectDefinition> readObjectDefinition(String objectID, String service, String accessToken) throws ExecutionException, InterruptedException;

    public GenericApiResponse<ObjectDefinition> deleteObjectDefinition(String request, String service, String accessToken) throws ExecutionException, InterruptedException;

}
