package com.zippy.api.repository;

import com.zippy.api.document.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends MongoRepository<Credential, String> {
    Optional<Credential> findByUsername(String username);
}
