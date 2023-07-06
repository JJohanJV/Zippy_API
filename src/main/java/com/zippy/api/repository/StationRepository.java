package com.zippy.api.repository;

import com.zippy.api.document.Station;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends MongoRepository<Station, ObjectId> {
    Station findByName(String name);
    Void deleteByName(String name);
}
