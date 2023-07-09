package com.zippy.api.rest;

import com.zippy.api.document.Credential;
import com.zippy.api.dto.UpdateDTO;
import com.zippy.api.repository.CredentialRepository;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/credentials")
public class CredentialREST {
    private final CredentialRepository credentialRepository;
    private final PasswordEncoder passwordEncoder;

    public CredentialREST(CredentialRepository credentialRepository, PasswordEncoder passwordEncoder) {
        this.credentialRepository = credentialRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // This endpoint returns the currently authenticated credential
    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal Credential credential) {
        return ResponseEntity.ok(credential);
    }

    // This endpoint return the credential by id, while the id is the same of the credential.
    @GetMapping("/{id}")
    @PreAuthorize("#credential.id == #id")
    public ResponseEntity<?> me(@AuthenticationPrincipal Credential credential, @PathVariable ObjectId id) {
        return ResponseEntity.ok(credentialRepository.findById(id));
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("#credential.id == #id")
    public ResponseEntity<?> changePassword(@NotNull @AuthenticationPrincipal Credential credential, @PathVariable ObjectId id, @NotNull @Valid @RequestBody UpdateDTO dto) {
        credential.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        credential.setEmail(dto.getNewEmail());
        credential.setUsername(dto.getNewUsername());
        credentialRepository.save(credential);
        return ResponseEntity.ok(credential);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("#credential.id == #id")
    public ResponseEntity<?> delete(@NotNull @AuthenticationPrincipal Credential credential, @PathVariable ObjectId id) {
        credentialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}