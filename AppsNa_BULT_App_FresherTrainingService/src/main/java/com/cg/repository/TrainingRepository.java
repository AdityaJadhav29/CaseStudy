package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.FresherModel;

public interface TrainingRepository extends MongoRepository<FresherModel, Integer>{

}
