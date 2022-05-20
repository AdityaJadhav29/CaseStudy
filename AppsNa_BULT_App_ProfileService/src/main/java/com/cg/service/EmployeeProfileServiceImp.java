package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.EmployeeModel;
import com.cg.repository.EmpProfileRepository;

@Service
public class EmployeeProfileServiceImp implements EmployeeProfileService {

	private EmpProfileRepository repository;

	@Autowired 
	public EmployeeProfileServiceImp(EmpProfileRepository emprepo) {
		super();
		this.repository = emprepo;
	}

	//add EmployeeDetails
	@Override
	public EmployeeModel addEmployeeDetails(EmployeeModel empd)throws DataAlreadyExistsException {
		if(repository.existsById(empd.getEmpId())) {
			throw new DataAlreadyExistsException();
		}
		EmployeeModel empsave=repository.save(empd);
		return empsave;
	}

	//getall EmployeeDetails
	@Override
	public List<EmployeeModel> getallEmployeeDetails() {
		return (List<EmployeeModel>)repository.findAll();
	}
	//delete EmployeeDetails
	@Override
	public void deleteEmployee(int empd)throws DataDoesNotExistsException {
		if(repository.existsById(empd)) {
			repository.deleteById(empd);
		}
		else throw new DataDoesNotExistsException();

	}

	//update EmployeeDetails
	@Override
	public EmployeeModel updateEmployeeDetails(EmployeeModel uempd)throws DataDoesNotExistsException {
		EmployeeModel record;
		Optional<EmployeeModel> opt=repository.findById(uempd.getEmpId());
		if(opt.isPresent()) {
			record=opt.get();
			record.setEmpName(uempd.getEmpName());
			record.setGender(uempd.getGender());
			record.setGrade(uempd.getGrade());
			record.setDegree(uempd.getDegree());
			record.setTech(uempd.getTech());
			record.setType(uempd.getType());
			record.setBuName(uempd.getBuName());
			record.setOfMailId(uempd.getOfMailId());
			record.setCollegeDetails(uempd.getCollegeDetails());
			record.setPersonalEmailId(uempd.getPersonalEmailId());
			record.setSpec(uempd.getSpec());
			record.setEduQualification(uempd.getEduQualification());
			record.setBuDemandMonth(uempd.getBuDemandMonth());
			record.setBuFullfillmentMonth(uempd.getBuFullfillmentMonth());
			record.setTrainingSDate(uempd.getTrainingSDate());
			record.setTraningEDate(uempd.getTraningEDate());
			record.setContactNo(uempd.getContactNo());
			repository.save(record);
		}else {
			throw new DataDoesNotExistsException();
		}
		return record;
	}

	@Override
	public EmployeeModel getEmployeeModelById(int empid) throws DataDoesNotExistsException {
	 Optional <EmployeeModel> opt=this.repository.findById(empid);
	 if(opt.isPresent())
	 {
		 return opt.get();
	 }else {
		 throw new DataDoesNotExistsException();
	 }
	
	}

}
