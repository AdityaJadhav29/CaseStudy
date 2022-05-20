package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.ProjectMappingModel;
import com.cg.repository.TrainingRepository;

@Service
public class TrainingServiceImp implements TrainingService {

	private TrainingRepository repository;
	
	public TrainingServiceImp(TrainingRepository trepo) {
		super();
		this.repository = trepo;
	}

	@Override
	public List<ProjectMappingModel> getByEmpId(int empid) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
