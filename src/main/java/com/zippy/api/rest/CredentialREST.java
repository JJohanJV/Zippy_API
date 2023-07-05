package com.zippy.api.rest;

import com.zippy.api.document.Credential;
import com.zippy.api.dto.TokenDTO;
import com.zippy.api.dto.UpdateDTO;
import com.zippy.api.repository.CredentialRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.zippy.api.service.CredentialService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/credentials")
public class CredentialREST {
    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    CredentialService credentialService;

    @Autowired
    PasswordEncoder passwordEncoder;

    // This endpoint returns the currently authenticated credential
    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal Credential credential) {
        return ResponseEntity.ok(credential);
    }

    // This endpoint return the credential by id, while the id is the same of the credential.
    @GetMapping("/{id}")
    @PreAuthorize("#credential.id == #id")
    public ResponseEntity<?> me(@AuthenticationPrincipal Credential credential, @PathVariable String id) {
        return ResponseEntity.ok(credentialRepository.findById(id));
    }

    @PutMapping("/update")
    @PreAuthorize("#credential.id == #dto.userId")
    public ResponseEntity<?> changePassword(@NotNull @AuthenticationPrincipal Credential credential, @NotNull @Valid @RequestBody UpdateDTO dto) {
        credential.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        credential.setEmail(dto.getNewEmail());
        credential.setUsername(dto.getNewUsername());
        credentialRepository.save(credential);
        return ResponseEntity.ok(credential);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("#credential.id == #id")
    public ResponseEntity<?> delete(@AuthenticationPrincipal Credential credential, @PathVariable String id) {
        credentialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}