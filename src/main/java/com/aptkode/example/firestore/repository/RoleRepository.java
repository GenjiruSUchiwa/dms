package com.aptkode.example.firestore.repository;

import com.aptkode.example.firestore.data.model.Role;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface RoleRepository extends FirestoreReactiveRepository<Role> {
}
