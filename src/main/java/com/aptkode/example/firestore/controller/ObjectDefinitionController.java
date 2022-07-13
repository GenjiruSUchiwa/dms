package com.aptkode.example.firestore.controller;

import com.aptkode.example.firestore.data.dto.Field;
import com.aptkode.example.firestore.data.dto.RegisterOD;
import com.aptkode.example.firestore.data.utils.GenericApiResponse;
import com.aptkode.example.firestore.data.model.ObjectDefinition;
import com.aptkode.example.firestore.service.api.ObjectDefinitionServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
@Component
@RestController
@CrossOrigin
@RequestMapping("/api/objectDefinition")
public class ObjectDefinitionController {

    @Autowired
    private ObjectDefinitionServiceApi objectDefinitionServiceApi;

    @PostMapping("/create")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> createObjectDefinition(@RequestBody RegisterOD registerOD, @RequestParam String serviceId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.saveObjectDefinition(registerOD, serviceId, userAcceccToken));
    }
    @PatchMapping("/update")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> updateObjectDefinition(@RequestBody RegisterOD registerOD, @RequestParam String serviceId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.updateObjectDefinition(registerOD, serviceId, userAcceccToken));
    }
    @PatchMapping("/field/update")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> updateObjectDefinitionFields(@RequestBody Field registerOD, @RequestParam String serviceId, @RequestParam String objectDefinitionId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.updateObjectDefinition(registerOD, serviceId,objectDefinitionId, userAcceccToken));
    }
    @PostMapping("/field/create")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> createObjectDefinitionFields(@RequestBody Field registerOD, @RequestParam String serviceId, @RequestParam String objectDefinitionId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.updateObjectDefinition(registerOD, serviceId,objectDefinitionId, userAcceccToken));
    }
    @DeleteMapping("/field/delete")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> deleeteObjectDefinitionFields(@RequestParam String fieldName, @RequestParam String serviceId, @RequestParam String objectDefinitionId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.updateObjectDefinition(fieldName, serviceId,objectDefinitionId, userAcceccToken));
    }
    @GetMapping("/read")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> readObjectDefinition(@RequestParam String objectId, @RequestParam String serviceId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.readObjectDefinition(objectId, serviceId, userAcceccToken));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> deleteObjectDefinition(@RequestParam String registerOD, @RequestParam String serviceId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.deleteObjectDefinition(registerOD, serviceId, userAcceccToken));
    }

    @GetMapping("/")
    public ResponseEntity<GenericApiResponse<ObjectDefinition>> getAllObjectDefinition(@RequestParam String registerOD, @RequestParam String serviceId, @RequestParam String userAcceccToken) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(objectDefinitionServiceApi.deleteObjectDefinition(registerOD, serviceId, userAcceccToken));
    }
}
