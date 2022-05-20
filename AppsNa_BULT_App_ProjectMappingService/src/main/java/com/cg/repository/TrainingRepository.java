package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.ProjectMappingModel;

public interface TrainingRepository extends MongoRepository<ProjectMappingModel, Integer>{

}
