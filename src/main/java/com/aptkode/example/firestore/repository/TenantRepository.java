package com.aptkode.example.firestore.repository;

import com.aptkode.example.firestore.data.model.Tenant;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface TenantRepository extends FirestoreReactiveRepository<Tenant> {
}
