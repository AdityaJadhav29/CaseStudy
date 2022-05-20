package com.cg.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ftrainingService")
public class FresherModel {

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
	
	public FresherModel() {
		super();
	}

	public FresherModel(int empId, int tId, int aId) {
		super();
		this.empId = empId;
		this.tId = tId;
		this.aId = aId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	
	public String getEmpName() {
		return empName;
	}

	public String getGender() {
		return gender;
	}

	public String getGrade() {
		return grade;
	}

	public String getDegree() {
		return degree;
	}

	public String getTech() {
		return tech;
	}

	public String getType() {
		return type;
	}

	public String getBuName() {
		return buName;
	}

	public String getOfMailId() {
		return ofMailId;
	}

	public String getCollegeDetails() {
		return collegeDetails;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public String getSpec() {
		return spec;
	}

	public String getEduQualification() {
		return eduQualification;
	}

	public String getBuDemandMonth() {
		return buDemandMonth;
	}

	public String getBuFullfillmentMonth() {
		return buFullfillmentMonth;
	}

	public Date getTrainingSDate() {
		return trainingSDate;
	}

	public Date getTraningEDate() {
		return traningEDate;
	}

	public String getMentor() {
		return mentor;
	}

	public String getTypeOfTraining() {
		return typeOfTraining;
	}

	public Date getsDate() {
		return sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public Map<String, String> getModuleList() {
		return moduleList;
	}

	@Override
	public String toString() {
		return "FresherModel [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", grade=" + grade
				+ ", degree=" + degree + ", tech=" + tech + ", type=" + type + ", buName=" + buName + ", ofMailId="
				+ ofMailId + ", collegeDetails=" + collegeDetails + ", personalEmailId=" + personalEmailId + ", spec="
				+ spec + ", eduQualification=" + eduQualification + ", buDemandMonth=" + buDemandMonth
				+ ", buFullfillmentMonth=" + buFullfillmentMonth + ", trainingSDate=" + trainingSDate
				+ ", traningEDate=" + traningEDate + ", tId=" + tId + ", mentor=" + mentor + ", typeOfTraining="
				+ typeOfTraining + ", sDate=" + sDate + ", eDate=" + eDate + ", aId=" + aId + ", finalScore="
				+ finalScore + ", moduleList=" + moduleList + "]";
	}
	
}

