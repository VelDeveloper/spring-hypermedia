package com.hypermedia.demo.repository;

import com.hypermedia.demo.model.Capability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends MongoRepository<Capability, String> {
}
