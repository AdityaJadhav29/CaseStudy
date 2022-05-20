package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.model.EmployeeModel;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmpProfileRepositoryTest {

	@Autowired
	private EmpProfileRepository empProfileRepository;
	
	Date date =new Date();
	
	
	@Test
	void returnEmployeeModelObject() {
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
		
		empProfileRepository.save(emp);
		EmployeeModel ep=empProfileRepository.findById(emp.getEmpId()).get();
		assertNotNull(ep);
	}
	
	
	@Test
	public void returnAllEmployeeModelObject() {
		
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
		
		List<EmployeeModel>aptList=(List<EmployeeModel>) empProfileRepository.findAll();
		assertEquals(3, aptList.get(2).getEmpId());
		
		
	}
	

}
