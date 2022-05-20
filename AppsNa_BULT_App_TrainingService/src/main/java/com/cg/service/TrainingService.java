package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.TrainingModel;


public interface TrainingService {

	public TrainingModel addTrainingDetails(TrainingModel empd)throws DataAlreadyExistsException;
	public List<TrainingModel> getallTrainingDetails();
	public void deleteTraining(int empd)throws DataDoesNotExistsException;
	public TrainingModel updateTrainingDetails(TrainingModel uempd)throws DataDoesNotExistsException;
	
	public TrainingModel getTrainingModelById(int empid) throws DataDoesNotExistsException;
}
