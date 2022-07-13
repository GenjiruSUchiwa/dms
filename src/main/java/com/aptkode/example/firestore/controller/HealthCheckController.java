package com.aptkode.example.firestore.controller;

import com.aptkode.example.firestore.data.dto.RegisterOD;
import com.aptkode.example.firestore.data.model.ObjectDefinition;
import com.aptkode.example.firestore.data.model.StatusEnum;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/")
public class HealthCheckController {
    @GetMapping("")
    public ResponseEntity<GenericApiResponse<String>> createObjectDefinition() throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(new GenericApiResponse(StatusEnum.SUCCESS.name(), "Server available and running", null, 200, ""));
    }
}