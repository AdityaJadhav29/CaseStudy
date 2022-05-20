package com.cg.controller;

import com.cg.model.FresherModel;
import com.cg.repository.TrainingRepository;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.service.TrainingService;

@RestController
@RequestMapping("/api/ftrain")
public class FresherProfileController {

	private TrainingService service;

	private TrainingRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public FresherProfileController(TrainingService emps) {
		super();
		this.service = emps;
	}

	//To add Employee Details 
	@PostMapping("/add")
	public ResponseEntity<FresherModel> addEmployee(@RequestBody  FresherModel empadd) throws DataAlreadyExistsException{
		FresherModel empsave=service.addFresherTrainingDetails(empadd);
		return new ResponseEntity<>(empsave,HttpStatus.CREATED);
	}

	//To get all Employee Details
	@GetMapping("/getall")
	public ResponseEntity<List<FresherModel>> Employee(){
		return new ResponseEntity<List<FresherModel>>((List<FresherModel>)service.getallFresherTrainingDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/getall/{empId}")
	public ResponseEntity<List<FresherModel>>  Employee1(@PathVariable int empId){
		List list1 =Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/pro/get/"+empId, FresherModel.class));
		Arrays.asList(restTemplate.getForObject("http://localhost:8083/api/train/get/"+empId, FresherModel.class));
		Arrays.asList(restTemplate.getForObject("http://localhost:8085/api/assesment/get/"+empId, FresherModel.class));
		  return new ResponseEntity<List<FresherModel>>((List<FresherModel>)service.getallFresherTrainingDetails(),HttpStatus.OK);

	}
	
	//To delete Employee Details
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empId)throws DataDoesNotExistsException{
		service.deleteFresherTraining(empId);
		return ResponseEntity.noContent().build();
	}
	//To Update Employee Details
	@PutMapping("/update")
	public FresherModel updateEmployee(@RequestBody FresherModel empu) throws DataDoesNotExistsException {
		return service.updateFresherTrainingDetails(empu);

	}


}
