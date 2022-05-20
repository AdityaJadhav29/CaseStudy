package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.FresherModel;


public interface TrainingService {

	public FresherModel addFresherTrainingDetails(FresherModel empd)throws DataAlreadyExistsException;
	public List<FresherModel> getallFresherTrainingDetails();
	public void deleteFresherTraining(int empd)throws DataDoesNotExistsException;
	public FresherModel updateFresherTrainingDetails(FresherModel uempd)throws DataDoesNotExistsException;
	
	
}
