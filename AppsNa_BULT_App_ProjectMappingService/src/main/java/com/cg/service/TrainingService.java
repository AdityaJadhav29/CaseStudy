package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.ProjectMappingModel;


public interface TrainingService {

	public List<ProjectMappingModel> getByEmpId(int empid);	
	
}
