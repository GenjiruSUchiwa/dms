package com.aptkode.example.firestore.service.api;

import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterUserRequest;
import com.aptkode.example.firestore.data.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface UserServiceApi {
    public GenericApiResponse<User> createUser(RegisterUserRequest request)throws ExecutionException, InterruptedException;
    public GenericApiResponse<User> updateUser(RegisterUserRequest request)throws ExecutionException, InterruptedException;
    public GenericApiResponse<List<User>> listUsers() throws ExecutionException, InterruptedException;;
}
