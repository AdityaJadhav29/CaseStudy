package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.TrainingModel;
import com.cg.repository.TrainingRepository;

@Service
public class TrainingServiceImp implements TrainingService {

	private TrainingRepository repository;
	
	public TrainingServiceImp(TrainingRepository trepo) {
		super();
		this.repository = trepo;
	}
	
	@Override
	public TrainingModel addTrainingDetails(TrainingModel empd) throws DataAlreadyExistsException {
		if(repository.existsById(empd.gettId())) {
			throw new DataAlreadyExistsException();
		}
		TrainingModel empsave=repository.save(empd);
		return empsave;
	}

	@Override
	public List<TrainingModel> getallTrainingDetails() {
		return (List<TrainingModel>)repository.findAll();
	}

	@Override
	public void deleteTraining(int empd) throws DataDoesNotExistsException {
		if(repository.existsById(empd)) {
			repository.deleteById(empd);
		}
		else throw new DataDoesNotExistsException();

	}

	@Override
	public TrainingModel updateTrainingDetails(TrainingModel uempd) throws DataDoesNotExistsException {
		TrainingModel record;
		Optional<TrainingModel> opt=repository.findById(uempd.gettId());
		if(opt.isPresent()) {		
			record=opt.get();
			record.setMentor(uempd.getMentor());
			record.setTypeOfTraining(uempd.getTypeOfTraining());
			record.setsDate(uempd.getsDate());
			record.seteDate(uempd.geteDate());
		}
			
	else {
		throw new DataDoesNotExistsException();
	}
	return record;
	}

	@Override
	public TrainingModel getTrainingModelById(int empid) throws DataDoesNotExistsException {
		Optional <TrainingModel> opt=this.repository.findById(empid);
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }else {
			 throw new DataDoesNotExistsException();
		 }
		
		}

}
