package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.TrainingModel;


public interface TrainingService {

	public List<TrainingModel> getallTrainingDetails(int empid);
	
}
