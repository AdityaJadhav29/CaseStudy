package com.cg.model;

import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="assesmentService")
public class AssesmentModel {

	//Attributes
	@Id
	private int aId;
	private int finalScore;
	private String typeOfTraining;
	private Map<String,String> moduleList; 
	
	
	//Default Constructor
	public AssesmentModel() {
		super();
		
	}

	//Parameterized Constructor
	public AssesmentModel(int aId, int finalScore, String typeOfTraining, Map<String, String> moduleList) {
		super();
		this.aId = aId;
		this.finalScore = finalScore;
		this.typeOfTraining = typeOfTraining;
		this.moduleList = moduleList;
	}

	
	//Setters and Getters
	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public String getTypeOfTraining() {
		return typeOfTraining;
	}

	public void setTypeOfTraining(String typeOfTraining) {
		this.typeOfTraining = typeOfTraining;
	}

	public Map<String, String> getModuleList() {
		return moduleList;
	}

	public void setModuleList(Map<String, String> moduleList) {
		this.moduleList = moduleList;
	}


	//ToString 
	@Override
	public String toString() {
		return "TrainingModel [aId=" + aId + ", finalScore=" + finalScore + ", typeOfTraining=" + typeOfTraining
				+ ", moduleList=" + moduleList + "]";
	}
	
}
