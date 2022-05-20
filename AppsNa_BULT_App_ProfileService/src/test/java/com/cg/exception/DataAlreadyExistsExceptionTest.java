package com.cg.exception;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.EmployeeModel;
import com.cg.repository.EmpProfileRepository;
import com.cg.service.EmployeeProfileService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DataAlreadyExistsExceptionTest {
	
	Date date =new Date();
	
	
	@Autowired
	private EmpProfileRepository empProfileRepository;
	
	@Autowired
	private EmployeeProfileService employeeProfileService;

	@Test
	public void assertThrowsaddEmployee() {
		EmployeeModel emp=new EmployeeModel(
				5,
			   "Aditya",
			    "Male",
			    "A4",
			     "BE",
			     "JFS",
			    "BULT",
			    "ABC",
			    "abc@capgemini.com",
			     "dypcoe",
			     "abc@gmail.com",
			    "JFS",
			    "CS",
			    "March",
			     "April",
			    date,
			    date,
			    (long) 1234567890);
		EmployeeModel emp1=new EmployeeModel(
				5,
			   "Aditya",
			    "Male",
			    "A4",
			     "BE",
			     "JFS",
			    "BULT",
			    "ABC",
			    "abc@capgemini.com",
			     "dypcoe",
			     "abc@gmail.com",
			    "JFS",
			    "CS",
			    "March",
			     "April",
			    date,
			    date,
			    (long) 1234567890);
	
	empProfileRepository.save(emp);
	empProfileRepository.save(emp1);
	
	
	assertThrows(DataAlreadyExistsException.class, ()->employeeProfileService.addEmployeeDetails(emp1),()->"Data Already Exists!!");
	
	
	}
}
