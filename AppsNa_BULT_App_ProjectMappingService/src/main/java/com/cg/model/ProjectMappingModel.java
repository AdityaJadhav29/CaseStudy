package com.cg.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="trainingService")
public class ProjectMappingModel {

	@Id
	private int empId;
	private String empName,gender,grade,degree,tech,type,buName,ofMailId,collegeDetails,personalEmailId,spec,eduQualification,buDemandMonth,buFullfillmentMonth;
	private Date trainingSDate,traningEDate;
	
	private int tId;
	private String mentor,typeOfTraining;
	private Date sDate,eDate;
	
	private int aId;
	private int finalScore;
	private Map<String,String> moduleList; 
	


	
}
