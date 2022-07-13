package com.aptkode.example.firestore.service.impl;

import com.aptkode.example.firestore.FirestoreApplication;
import com.aptkode.example.firestore.Gender;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterUserRequest;
import com.aptkode.example.firestore.data.model.StatusEnum;
import com.aptkode.example.firestore.data.model.User;
import com.aptkode.example.firestore.handler.UserHandler;
import com.aptkode.example.firestore.repository.UserRepository;
import com.aptkode.example.firestore.service.api.UserServiceApi;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Component
public class UserServiceImpl implements UserServiceApi {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHandler userHandler;
    private final static Logger logger = LoggerFactory.getLogger(FirestoreApplication.class);
    @Autowired
    private Firestore firestore;
    @Override
    public GenericApiResponse<User> createUser(RegisterUserRequest request) throws ExecutionException, InterruptedException {
        User userToCreate = new User(request.getFirstName(), request.getLastName(), new Date(request.getDoB()), Gender.valueOf(request.getGender()), request.getPhoto(), request.getAccessKey());
        ApiFuture<WriteResult> apiFuture = this.firestore.collection("users").document().set(userToCreate);
        WriteResult writeResult = apiFuture.get();
        logger.info("Update time: {}", writeResult.getUpdateTime());
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully created", null, 200, writeResult);

    }

    @Override
    public GenericApiResponse<User> updateUser(RegisterUserRequest request) {
        User userToCreate = new User(request.getFirstName(), request.getLastName(), new Date(request.getDoB()), Gender.valueOf(request.getGender()), request.getPhoto(), request.getAccessKey());
        try {
            User userCreated = userRepository.save(userToCreate).block();
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully updated", null, 200, userCreated);
        } catch (Exception exception) {
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", exception.getStackTrace().toString(), 500, null);
        }
    }

    @Override
    public GenericApiResponse<List<User>> listUsers() {
        try {
            List<User> users = userRepository.findAll().collectList().block();
            return new GenericApiResponse(StatusEnum.SUCCESS.name(), "user successfully updated", null, 200, users);
        } catch (Exception e) {
            return new GenericApiResponse(StatusEnum.FAILED.name(), "failed to update user", e.getStackTrace().toString(), 500, null);
        }



    }
}
