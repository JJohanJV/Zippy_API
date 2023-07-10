package com.zippy.api.service;

import com.zippy.api.document.Credential;
import com.zippy.api.dto.CredentialDTO;
import com.zippy.api.repository.CredentialRepository;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zippy.api.constants.Roles;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class CredentialService implements UserDetailsService {
    private final CredentialRepository credentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public CredentialService(CredentialRepository credentialRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.credentialRepository = credentialRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Credential loadUserByUsername(String username) throws UsernameNotFoundException {
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }

    public Credential findById(ObjectId id) {
        return credentialRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user id not found"));
    }

    public Credential createNewCredentialByDto(CredentialDTO dto, ObjectId userId, Roles role) {
        return credentialRepository.save(new Credential(new ObjectId(), dto.getUsername(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()), role, userId));
    }

    public void deleteCredential(Credential credential) {
        userService.deleteUserById(credential.getUserId());
        credentialRepository.deleteById(credential.getId());
    }

    public Credential updateCredential(Credential credential){
        return credentialRepository.save(credential);
    }
}