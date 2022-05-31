package com.cg.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="empProfile")
public class EmployeeModel {

	//Attributes
	@Id
	private int empId;
	private String empName,gender,grade,degree,tech,type,buName,ofMailId,collegeDetails,personalEmailId,spec,eduQualification,buDemandMonth,buFullfillmentMonth;
	private Date trainingSDate,traningEDate;
	private Long contactNo;


	//Default Constructor
	public EmployeeModel() {
		super();
		
	}


	//Parameterized Constructor
	public EmployeeModel(int empId, String empName, String gender, String grade, String degree, String tech,
			String type, String buName, String ofMailId, String collegeDetails, String personalEmailId, String spec,
			String eduQualification, String buDemandMonth, String buFullfillmentMonth, Date trainingSDate,
			Date traningEDate, Long contactNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.grade = grade;
		this.degree = degree;
		this.tech = tech;
		this.type = type;
		this.buName = buName;
		this.ofMailId = ofMailId;
		this.collegeDetails = collegeDetails;
		this.personalEmailId = personalEmailId;
		this.spec = spec;
		this.eduQualification = eduQualification;
		this.buDemandMonth = buDemandMonth;
		this.buFullfillmentMonth = buFullfillmentMonth;
		this.trainingSDate = trainingSDate;
		this.traningEDate = traningEDate;
		this.contactNo = contactNo;
	}


	//Setters and Getters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getOfMailId() {
		return ofMailId;
	}
	public void setOfMailId(String ofMailId) {
		this.ofMailId = ofMailId;
	}
	public String getCollegeDetails() {
		return collegeDetails;
	}
	public void setCollegeDetails(String collegeDetails) {
		this.collegeDetails = collegeDetails;
	}
	public String getPersonalEmailId() {
		return personalEmailId;
	}
	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getEduQualification() {
		return eduQualification;
	}
	public void setEduQualification(String eduQualification) {
		this.eduQualification = eduQualification;
	}
	public String getBuDemandMonth() {
		return buDemandMonth;
	}
	public void setBuDemandMonth(String buDemandMonth) {
		this.buDemandMonth = buDemandMonth;
	}
	public String getBuFullfillmentMonth() {
		return buFullfillmentMonth;
	}
	public void setBuFullfillmentMonth(String buFullfillmentMonth) {
		this.buFullfillmentMonth = buFullfillmentMonth;
	}
	public Date getTrainingSDate() {
		return trainingSDate;
	}
	public void setTrainingSDate(Date trainingSDate) {
		this.trainingSDate = trainingSDate;
	}
	public Date getTraningEDate() {
		return traningEDate;
	}
	public void setTraningEDate(Date traningEDate) {
		this.traningEDate = traningEDate;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	//ToString 
	@Override
	public String toString() {
		return "EmployeeModel [empID=" + empId + ", empName=" + empName + ", gender=" + gender + ", grade=" + grade
				+ ", degree=" + degree + ", tech=" + tech + ", type=" + type + ", buName=" + buName + ", ofMailId="
				+ ofMailId + ", collegeDetails=" + collegeDetails + ", personalEmailId=" + personalEmailId + ", spec="
				+ spec + ", eduQualification=" + eduQualification + ", buDemandMonth=" + buDemandMonth
				+ ", buFullfillmentMonth=" + buFullfillmentMonth + ", trainingSDate=" + trainingSDate
				+ ", traningEDate=" + traningEDate + ", contactNo=" + contactNo + "]";
	}

}
