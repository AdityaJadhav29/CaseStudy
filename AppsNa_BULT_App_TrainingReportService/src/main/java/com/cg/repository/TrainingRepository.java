package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.TrainingModel;

public interface TrainingRepository extends MongoRepository<TrainingModel, Integer>{

}
