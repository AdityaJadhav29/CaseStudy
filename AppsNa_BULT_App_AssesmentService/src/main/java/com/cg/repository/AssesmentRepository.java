package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.AssesmentModel;


//connected to mongodb using AssesmentModel
public interface AssesmentRepository extends MongoRepository<AssesmentModel, Integer>{

}
