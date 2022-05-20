package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.AssesmentModel;


public interface AssesmentService {

	//add AssesmentDetails
	public AssesmentModel addAssesmentDetails(AssesmentModel empd)throws DataAlreadyExistsException;
	//getall AssesmentDetails
	public List<AssesmentModel> getallAssesmentDetails();
	//delete AssesmentDetails
	public void deleteAssesment(int empd)throws DataDoesNotExistsException;
	//update AssesmentDetails
	public AssesmentModel updateAssesmentDetails(AssesmentModel uempd)throws DataDoesNotExistsException;
	
	public AssesmentModel getTrainingModelById(int empid) throws DataDoesNotExistsException;
}
