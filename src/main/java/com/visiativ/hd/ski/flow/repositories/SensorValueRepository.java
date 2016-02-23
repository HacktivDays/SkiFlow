package com.visiativ.hd.ski.flow.repositories;

import com.visiativ.hd.ski.flow.domain.SensorValue;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by visiativ on 23/02/16.
 */
public interface SensorValueRepository extends MongoRepository<SensorValue, String> {
}
