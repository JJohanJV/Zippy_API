package com.zippy.api.service;

import com.zippy.api.document.BillingInformation;
import com.zippy.api.document.User;
import com.zippy.api.dto.AddressDTO;
import com.zippy.api.dto.BackupPersonDTO;
import com.zippy.api.dto.UserDTO;
import com.zippy.api.models.*;
import com.zippy.api.repository.BillingInformationRepository;
import com.zippy.api.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BillingInformationRepository billingInformationRepository;

    public UserService(UserRepository userRepository, BillingInformationRepository billingInformationRepository) {
        this.userRepository = userRepository;
        this.billingInformationRepository = billingInformationRepository;
    }

    private Address createAddress(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getDetail(),
                new City(addressDTO.getCity().getId(), addressDTO.getCity().getName()),
                new State(addressDTO.getState().getId(), addressDTO.getState().getName()),
                new Country(addressDTO.getCountry().getId(), addressDTO.getCountry().getName()));
    }

    private BackupPerson createBackupPerson(BackupPersonDTO backupPersonDTO) {
        return new BackupPerson(
                backupPersonDTO.getName(),
                backupPersonDTO.getLastname(),
                backupPersonDTO.getPhone(),
                backupPersonDTO.getEmail(),
                backupPersonDTO.getDocument(),
                backupPersonDTO.getDocumentType());
    }

    public User createNewUser(@Valid UserDTO userDTO) {
        AddressDTO addressDTO = userDTO.getAddress();
        BackupPersonDTO backupPersonDTO = userDTO.getBackupPerson();
        BillingInformation billingInformation = new BillingInformation();

        Address address = createAddress(addressDTO);

        BackupPerson backupPerson = createBackupPerson(backupPersonDTO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime birthday = LocalDateTime.parse(userDTO.getBirthday(), formatter);

        User user = new User(
                new ObjectId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                birthday,
                userDTO.getOccupation(),
                userDTO.getEmail(),
                userDTO.getPhone(),
                userDTO.getDocument(),
                userDTO.getDocumentType(),
                billingInformation.getId(),
                backupPerson,
                address
        );

        billingInformationRepository.save(billingInformation);
        return userRepository.save(user);
    }

    public Object saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User getUserById(ObjectId id) {
        return userRepository.findById(id).orElse(null);
    }


}
