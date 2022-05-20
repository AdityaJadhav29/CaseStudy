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
import com.cg.model.AssesmentModel;
import com.cg.service.AssesmentService;

@RestController
@RequestMapping("/api/assesment")
public class AssesmentController {

	private AssesmentService service;

	@Autowired
	public AssesmentController(AssesmentService emps) {
		super();
		this.service = emps;
	}

	//To add Assesment Details 
	@PostMapping("/add")
	public ResponseEntity<AssesmentModel> addEmployee(@RequestBody  AssesmentModel empadd) throws DataAlreadyExistsException{
		AssesmentModel empsave=service.addAssesmentDetails(empadd);
		return new ResponseEntity<>(empsave,HttpStatus.CREATED);
	}

	//To get all Assesment Details
	@GetMapping("/getall")
	public ResponseEntity<List<AssesmentModel>> Employee(){
		return new ResponseEntity<List<AssesmentModel>>((List<AssesmentModel>)service.getallAssesmentDetails(),HttpStatus.OK);
	}

	//To delete Assesment Details
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empId)throws DataDoesNotExistsException{
		service.deleteAssesment(empId);
		return ResponseEntity.noContent().build();
	}
	//To Update Assesment Details
	@PutMapping("/update")
	public AssesmentModel updateEmployee(@RequestBody AssesmentModel empu) throws DataDoesNotExistsException {
		return service.updateAssesmentDetails(empu);

	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<AssesmentModel> getEmployee(@PathVariable int empId) throws DataDoesNotExistsException {
		return ResponseEntity.ok().body(service.getTrainingModelById(empId));
		
	}
	

}
