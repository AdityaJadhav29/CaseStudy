package com.cg.model;

public class JWTResponse {

	
	//Attributes
	private String jwtToken;

	
	//Default Constructor
	public JWTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Parameterized Constructor
	public JWTResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	//Setters and Getters
	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	
	//ToString 
	@Override
	public String toString() {
		return "JWTResponse [jwtToken=" + jwtToken + "]";
	}
	
}
