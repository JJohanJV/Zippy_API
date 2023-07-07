package com.zippy.api.repository;

import com.zippy.api.document.BillingInformation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInformationRepository extends MongoRepository<BillingInformation, ObjectId> {

}
