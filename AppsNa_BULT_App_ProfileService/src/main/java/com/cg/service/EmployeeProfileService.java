package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.EmployeeModel;

public interface EmployeeProfileService {

	
	//add EmployeeDetails
	public EmployeeModel addEmployeeDetails(EmployeeModel empd)throws DataAlreadyExistsException;
	//getall EmployeeDetails
	public List<EmployeeModel> getallEmployeeDetails();
	//delete EmployeeDetails
	public void deleteEmployee(int empd)throws DataDoesNotExistsException;
	//update EmployeeDetails
	public EmployeeModel updateEmployeeDetails(EmployeeModel uempd)throws DataDoesNotExistsException;
	
	public EmployeeModel getEmployeeModelById(int empid) throws DataDoesNotExistsException;
	
	
}
