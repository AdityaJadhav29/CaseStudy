package com.cg.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.FresherModel;
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
	public FresherModel addFresherTrainingDetails(FresherModel empd) throws DataAlreadyExistsException {
		if(repository.existsById(empd.getEmpId())) {
			throw new DataAlreadyExistsException();
		}
		FresherModel fm =restTemplate.getForObject("http://localhost:8082/api/pro/get/"+empd.getEmpId(), FresherModel.class);
		repository.save(fm);
		fm=restTemplate.getForObject("http://localhost:8083/api/train/get/"+empd.gettId(), FresherModel.class);
		repository.save(fm);
		fm=restTemplate.getForObject("http://localhost:8085/api/assesment/get/"+empd.getaId(), FresherModel.class);
		FresherModel empsave=repository.save(fm);
		return empsave;
	}

	@Override
	public List<FresherModel> getallFresherTrainingDetails() {
		
		FresherModel f1=new FresherModel();
	
		
		return (List<FresherModel>)repository.findAll();
	}

	@Override
	public void deleteFresherTraining(int empd) throws DataDoesNotExistsException {
		if(repository.existsById(empd)) {
			repository.deleteById(empd);
		}
		else throw new DataDoesNotExistsException();

	}

	@Override
	public FresherModel updateFresherTrainingDetails(FresherModel uempd) throws DataDoesNotExistsException {
		FresherModel record;
		Optional<FresherModel> opt=repository.findById(uempd.getEmpId());
		if(opt.isPresent()) {		
			record=opt.get();
			record.setaId(uempd.getaId());
			record.settId(uempd.gettId());
		}
			
	else {
		throw new DataDoesNotExistsException();
	}
	return record;
	}

	

}
