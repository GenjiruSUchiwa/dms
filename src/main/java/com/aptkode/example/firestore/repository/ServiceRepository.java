package com.aptkode.example.firestore.repository;

import com.aptkode.example.firestore.data.model.Service;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface ServiceRepository extends FirestoreReactiveRepository<Service> {
}
