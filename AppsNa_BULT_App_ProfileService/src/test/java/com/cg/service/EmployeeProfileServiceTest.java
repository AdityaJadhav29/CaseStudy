package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.model.EmployeeModel;
import com.cg.repository.EmpProfileRepository;


@ExtendWith(MockitoExtension.class)
class EmployeeProfileServiceTest {

	Date date =new Date();
	
	@Mock
	private EmpProfileRepository empProfileRepository;
	
	@InjectMocks
	private EmployeeProfileServiceImp employeeProfileServiceImp;
	
	@Test
	void addEmployee() throws DataAlreadyExistsException {
		EmployeeModel emp=new EmployeeModel(
				1,
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
		when(empProfileRepository.save(any())).thenReturn(emp);
		employeeProfileServiceImp.addEmployeeDetails(emp);
		verify(empProfileRepository,times(1)).save(any());
	}

	@Test
	public void TestallEmployeeModel() {
		EmployeeModel emp=new EmployeeModel(
				1,
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
				2,
			   "Ajay",
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
		EmployeeModel emp2=new EmployeeModel(
				3,
			   "Siddharth",
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
		empProfileRepository.save(emp2);
		
		List<EmployeeModel>aptList=new ArrayList<EmployeeModel>();
		aptList.add(emp);
		aptList.add(emp1);
		aptList.add(emp2);
		when(empProfileRepository.findAll()).thenReturn(aptList);
		List<EmployeeModel>aptList1=employeeProfileServiceImp.getallEmployeeDetails();
		assertEquals(aptList,aptList1);
		verify(empProfileRepository,times(1)).save(emp);
		verify(empProfileRepository,times(1)).findAll();
		
	}
}
