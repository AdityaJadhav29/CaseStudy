package com.cg.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="trainingService")
public class TrainingModel {

	@Id
	private int tId;
	private String mentor,typeOfTraining;
	private Date sDate,eDate;
	
	public TrainingModel() {
		super();
		
	}


	public TrainingModel(int tId, String mentor, String typeOfTraining, Date sDate, Date eDate) {
		super();
		this.tId = tId;
		this.mentor = mentor;
		this.typeOfTraining = typeOfTraining;
		this.sDate = sDate;
		this.eDate = eDate;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public String getTypeOfTraining() {
		return typeOfTraining;
	}

	public void setTypeOfTraining(String typeOfTraining) {
		this.typeOfTraining = typeOfTraining;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}


	@Override
	public String toString() {
		return "TrainingModel [tId=" + tId + ", mentor=" + mentor + ", typeOfTraining=" + typeOfTraining + ", sDate="
				+ sDate + ", eDate=" + eDate + "]";
	}
	
}
