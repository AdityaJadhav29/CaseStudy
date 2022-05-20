package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.EmployeeModel;

//connected to mongodb using EmployeeModel
public interface EmpProfileRepository extends MongoRepository<EmployeeModel, Integer> {

}
