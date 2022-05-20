package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.EmployeeModel;
import com.cg.service.EmployeeProfileService;

@RestController
@RequestMapping("/api/pro")
public class EmployeeProfileController {

	private EmployeeProfileService service;

	@Autowired
	public EmployeeProfileController(EmployeeProfileService emps) {
		super();
		this.service = emps;
	}

	//To add Employee Details 
	@PostMapping("/add")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody  EmployeeModel empadd) throws DataAlreadyExistsException{
		EmployeeModel empsave=service.addEmployeeDetails(empadd);
		return new ResponseEntity<>(empsave,HttpStatus.CREATED);
	}

	//To get all Employee Details
	@GetMapping("/getall")
	public ResponseEntity<List<EmployeeModel>> Employee(){
		return new ResponseEntity<List<EmployeeModel>>((List<EmployeeModel>)service.getallEmployeeDetails(),HttpStatus.OK);
	}

	//To delete Employee Details
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empId)throws DataDoesNotExistsException{
		service.deleteEmployee(empId);
		return ResponseEntity.noContent().build();
	}
	//To Update Employee Details
	@PutMapping("/update")
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel empu) throws DataDoesNotExistsException {
		return service.updateEmployeeDetails(empu);

	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable int empId) throws DataDoesNotExistsException {
		return ResponseEntity.ok().body(service.getEmployeeModelById(empId));
		
	}
	
	

}
