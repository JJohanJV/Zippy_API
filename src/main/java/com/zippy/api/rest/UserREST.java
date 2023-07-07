package com.zippy.api.rest;

import com.zippy.api.document.BillingInformation;
import com.zippy.api.document.Credential;
import com.zippy.api.document.User;
import com.zippy.api.dto.UserDTO;
import com.zippy.api.dto.updateUserDTO;
import com.zippy.api.service.UserService;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserREST {

    private final UserService userService;

    @Autowired
    public UserREST(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@NotNull @AuthenticationPrincipal Credential credential, @Valid @RequestBody UserDTO dto ){
        BillingInformation billingInformation = new BillingInformation();
        User user = new User(new ObjectId(),new ObjectId(credential.getId()), dto.getName(), dto.getLastname(), dto.getBirthday(), dto.getOccupation(),
                dto.getEmail(), dto.getPhone(),dto.getDocument(),dto.getDocumentType(),
                billingInformation.getId(), dto.getBackupPerson(), dto.getAddress());
        credential.setUserId(user.getId());
        return ResponseEntity.ok(userService.addUser(user,billingInformation));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String id, @Valid @RequestBody updateUserDTO dto){
        User user = userService.getUserById(id);
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setOccupation(dto.getOccupation());
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping ("/{id}")
    @PreAuthorize("#credential.userId == #id")
    public ResponseEntity<?> getUser(@NotNull @AuthenticationPrincipal Credential credential, @PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("#credential.userId == #id")
    public ResponseEntity<?> deleteUser(@NotNull @AuthenticationPrincipal Credential credential, @PathVariable String id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
