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
import com.cg.model.TrainingModel;
import com.cg.service.TrainingService;

@RestController
@RequestMapping("/api/train")
public class EmployeeTrainingController {

	private TrainingService service;

	@Autowired
	public EmployeeTrainingController(TrainingService emps) {
		super();
		this.service = emps;
	}

	//To add Employee Details 
	@PostMapping("/add")
	public ResponseEntity<TrainingModel> addEmployee(@RequestBody  TrainingModel empadd) throws DataAlreadyExistsException{
		TrainingModel empsave=service.addTrainingDetails(empadd);
		return new ResponseEntity<>(empsave,HttpStatus.CREATED);
	}

	//To get all Employee Details
	@GetMapping("/getall")
	public ResponseEntity<List<TrainingModel>> Employee(){
		return new ResponseEntity<List<TrainingModel>>((List<TrainingModel>)service.getallTrainingDetails(),HttpStatus.OK);
	}

	//To delete Employee Details
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empId)throws DataDoesNotExistsException{
		service.deleteTraining(empId);
		return ResponseEntity.noContent().build();
	}
	//To Update Employee Details
	@PutMapping("/update")
	public TrainingModel updateEmployee(@RequestBody TrainingModel empu) throws DataDoesNotExistsException {
		return service.updateTrainingDetails(empu);

	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<TrainingModel> getEmployee(@PathVariable int empId) throws DataDoesNotExistsException {
		return ResponseEntity.ok().body(service.getTrainingModelById(empId));
		
	}
	
	

}
