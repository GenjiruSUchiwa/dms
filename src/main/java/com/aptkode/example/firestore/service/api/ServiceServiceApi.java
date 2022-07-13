package com.aptkode.example.firestore.service.api;

import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterServicePOJO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface ServiceServiceApi {
    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> createServer(RegisterServicePOJO request) throws ExecutionException, InterruptedException;

    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> updateServer(RegisterServicePOJO request, String accessToken) throws ExecutionException, InterruptedException;

    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> readService(String request, String accessToken) throws ExecutionException, InterruptedException;

    public GenericApiResponse<com.aptkode.example.firestore.data.model.Service> deleteService(String request, String accessToken) throws ExecutionException, InterruptedException;
    public GenericApiResponse<List<com.aptkode.example.firestore.data.model.Service>> getAllServices(String accessToken) throws ExecutionException, InterruptedException;
}