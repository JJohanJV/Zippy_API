package com.zippy.api.service;

import com.zippy.api.document.BillingInformation;
import com.zippy.api.document.User;
import com.zippy.api.dto.AddressDTO;
import com.zippy.api.dto.BackupPersonDTO;
import com.zippy.api.dto.UserDTO;
import com.zippy.api.models.*;
import com.zippy.api.repository.BillingInformationRepository;
import com.zippy.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import javax.validation.Valid;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BillingInformationRepository billingInformationRepository;

    public UserService (UserRepository userRepository, BillingInformationRepository billingInformationRepository){
        this.userRepository = userRepository;
        this.billingInformationRepository = billingInformationRepository;
    }
    public User createNewUser(@Valid UserDTO userDTO, ObjectId credentialId){
        AddressDTO addressDTO = userDTO.getAddress();
        BackupPersonDTO backupPersonDTO = userDTO.getBackupPerson();
        BillingInformation billingInformation = new BillingInformation();

        Address address = new Address(
                addressDTO.getDetail(),
                new City(
                        addressDTO.getCity().getId(),
                        addressDTO.getCity().getName()
                ),
                new Country(1, "Colombia"),
                new State(36, "Santander")
        );

        BackupPerson backupPerson = new BackupPerson(
                backupPersonDTO.getName(),
                backupPersonDTO.getLastname(),
                backupPersonDTO.getPhone(),
                backupPersonDTO.getEmail(),
                backupPersonDTO.getDocument(),
                backupPersonDTO.getDocumentType()
        );
        User user = new User(new ObjectId(), credentialId, userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthday(), userDTO.getOccupation(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getDocument(), userDTO.getDocumentType(), billingInformation.getId(), backupPerson, address);

        billingInformationRepository.save(billingInformation);
        return userRepository.save(user);
    }

    public Object saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUserById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User getUserById(ObjectId id) {
        return userRepository.findById(id).orElse(null);
    }



}
