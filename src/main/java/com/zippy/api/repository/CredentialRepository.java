package com.zippy.api.repository;

import com.zippy.api.document.Credential;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends MongoRepository<Credential, ObjectId> {
    Optional<Credential> findByUsername(String username);

    Optional<Credential> findByEmail(String email);

    default Boolean existsByUsername(String username) {
        return findByUsername(username).isPresent();
    }

    default Boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }
}
