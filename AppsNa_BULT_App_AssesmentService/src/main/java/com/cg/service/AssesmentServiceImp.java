package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.AssesmentModel;
import com.cg.repository.AssesmentRepository;

@Service
public class AssesmentServiceImp implements AssesmentService {

	private AssesmentRepository repository;
	
	public AssesmentServiceImp(AssesmentRepository trepo) {
		super();
		this.repository = trepo;
	}
	
	//add AssesmentDetails
	@Override
	public AssesmentModel addAssesmentDetails(AssesmentModel empd) throws DataAlreadyExistsException {
		if(repository.existsById(empd.getaId())) {
			throw new DataAlreadyExistsException();
		}
		AssesmentModel empsave=repository.save(empd);
		return empsave;
	}

	//getall AssesmentDetails
	@Override
	public List<AssesmentModel> getallAssesmentDetails() {
		return (List<AssesmentModel>)repository.findAll();
	}

	//delete AssesmentDetails
	@Override
	public void deleteAssesment(int empd) throws DataDoesNotExistsException {
		if(repository.existsById(empd)) {
			repository.deleteById(empd);
		}
		else throw new DataDoesNotExistsException();

	}

	//update AssesmentDetails
	@Override
	public AssesmentModel updateAssesmentDetails(AssesmentModel uempd) throws DataDoesNotExistsException {
		AssesmentModel record;
		Optional<AssesmentModel> opt=repository.findById(uempd.getaId());
		if(opt.isPresent()) {		
			record=opt.get();
			record.setTypeOfTraining(uempd.getTypeOfTraining());
			record.setModuleList(uempd.getModuleList());
			record.setFinalScore(uempd.getFinalScore());
		}
			
	else {
		throw new DataDoesNotExistsException();
	}
	return record;
	}
	
	@Override
	public AssesmentModel getTrainingModelById(int empid) throws DataDoesNotExistsException {
		Optional <AssesmentModel> opt=this.repository.findById(empid);
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }else {
			 throw new DataDoesNotExistsException();
		 }
		
		}

}
