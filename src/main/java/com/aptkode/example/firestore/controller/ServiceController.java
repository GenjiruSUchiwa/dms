package com.aptkode.example.firestore.controller;

import com.aptkode.example.firestore.data.model.Service;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.dto.RegisterServicePOJO;
import com.aptkode.example.firestore.service.api.ServiceServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@Component
@RestController
@CrossOrigin
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    ServiceServiceApi serviceServiceApi;

    @PostMapping("/save")
    private ResponseEntity<GenericApiResponse<Service>> saveUser(@RequestBody RegisterServicePOJO request) throws ExecutionException, InterruptedException {
        return new ResponseEntity<GenericApiResponse<Service>>(serviceServiceApi.createServer(request), HttpStatus.OK);
    }

    @PatchMapping("/update")
    private ResponseEntity<GenericApiResponse<Service>> updateService(@RequestBody RegisterServicePOJO request, @RequestParam String accessToken) throws ExecutionException, InterruptedException {
        return new ResponseEntity<GenericApiResponse<Service>>(serviceServiceApi.updateServer(request, accessToken), HttpStatus.OK);
    }

    @GetMapping("/read")
    private ResponseEntity<GenericApiResponse<Service>> readService(@RequestParam String request, @RequestParam String accessToken) throws ExecutionException, InterruptedException {
        return new ResponseEntity<GenericApiResponse<Service>>(serviceServiceApi.readService(request, accessToken), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<GenericApiResponse<Service>> deleteService(@RequestParam String request, @RequestParam String accessToken) throws ExecutionException, InterruptedException {
        return new ResponseEntity<GenericApiResponse<Service>>(serviceServiceApi.deleteService(request, accessToken), HttpStatus.OK);
    }
    @GetMapping("/")
    private ResponseEntity<GenericApiResponse<List<Service>>> getAllServices(@RequestParam String accessToken) throws ExecutionException, InterruptedException {
        return new ResponseEntity<GenericApiResponse<List<Service>>>(serviceServiceApi.getAllServices(accessToken), HttpStatus.OK);
    }
}
