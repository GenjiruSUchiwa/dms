package com.aptkode.example.firestore.controller;


import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterUserRequest;
import com.aptkode.example.firestore.data.model.User;
import com.aptkode.example.firestore.handler.UserHandler;
import com.aptkode.example.firestore.service.api.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@Component
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceApi userServiceApi;


    @Autowired
    private UserHandler userHandler;

    @PostMapping("/save")
    private ResponseEntity<GenericApiResponse<User>> saveUser(@RequestBody RegisterUserRequest request) throws ExecutionException, InterruptedException{
        return new ResponseEntity<GenericApiResponse<User>>(userServiceApi.createUser(request), HttpStatus.OK);
    }

    private ResponseEntity<GenericApiResponse<User>> updateUser(@RequestBody RegisterUserRequest request) throws ExecutionException, InterruptedException{
        return new ResponseEntity<GenericApiResponse<User>>(userServiceApi.updateUser(request), HttpStatus.OK);
    }

    private ResponseEntity<GenericApiResponse<List<User>>> updateUser() throws ExecutionException, InterruptedException{
        return new ResponseEntity<GenericApiResponse<List<User>>>(userServiceApi.listUsers(), HttpStatus.OK);
    }
}
