package com.zippy.api.service;

import com.zippy.api.document.BillingInformation;
import com.zippy.api.document.User;
import com.zippy.api.repository.BillingInformationRepository;
import com.zippy.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BillingInformationRepository billingInformationRepository;

    public UserService (UserRepository userRepository, BillingInformationRepository billingInformationRepository){
        this.userRepository = userRepository;
        this.billingInformationRepository = billingInformationRepository;
    }

    public Object addUser(User user, BillingInformation billingInformation){
        billingInformationRepository.save(billingInformation);
        return userRepository.save(user);
    }

    public Object updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(new ObjectId(id));
    }

    public User getUserById(String id) {
        return userRepository.findById(new ObjectId(id)).orElse(null);
    }



}
