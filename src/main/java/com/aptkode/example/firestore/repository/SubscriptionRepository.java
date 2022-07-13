package com.aptkode.example.firestore.repository;

import com.aptkode.example.firestore.data.model.Subscription;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface SubscriptionRepository extends FirestoreReactiveRepository<Subscription> {
}
