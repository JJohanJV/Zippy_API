package com.zippy.api.repository;

import com.zippy.api.document.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface CredentialRepository extends MongoRepository<Credential, String> {
    Optional<Credential> findByUsername(String username);
}
