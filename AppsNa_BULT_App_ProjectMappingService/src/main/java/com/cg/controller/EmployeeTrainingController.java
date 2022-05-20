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
import com.cg.model.ProjectMappingModel;
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

	//To get Employee Details by Emplyoee Id
	@GetMapping("/get/{empid}")
	public ResponseEntity<List<ProjectMappingModel>> Employee(@PathVariable int empId){
		return new ResponseEntity<List<ProjectMappingModel>>((List<ProjectMappingModel>)service.getByEmpId(empId),HttpStatus.OK);
	}




}
