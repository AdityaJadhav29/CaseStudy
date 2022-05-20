package com.cg.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.TrainingModel;
import com.cg.repository.TrainingRepository;

@Service
public class TrainingServiceImp implements TrainingService {

	private TrainingRepository repository;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TrainingServiceImp(TrainingRepository trepo) {
		super();
		this.repository = trepo;
	}
	
	@Override
	public List<TrainingModel> getallTrainingDetails(@PathVariable int empId) {
		List list1 =Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/pro/get/"+empId, TrainingModel.class));
		Arrays.asList(restTemplate.getForObject("http://localhost:8083/api/train/get/"+empId, TrainingModel.class));
		Arrays.asList(restTemplate.getForObject("http://localhost:8085/api/assesment/get/"+empId, TrainingModel.class));
		
		
		return (List<TrainingModel>)repository.findAll();
	}

}
