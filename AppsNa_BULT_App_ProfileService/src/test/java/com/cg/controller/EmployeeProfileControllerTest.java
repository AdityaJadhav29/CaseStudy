package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.EmployeeModel;
import com.cg.repository.EmpProfileRepository;
import com.cg.service.EmployeeProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
class EmployeeProfileControllerTest {

	Date date =new Date();
	
	@Autowired
	public MockMvc mockMvc;
	
	
	
	@Mock
	private EmployeeProfileService employeeProfileService;
	private EmployeeModel employeeModel;
	private List<EmployeeModel> aList;
	
	
	@InjectMocks
	private EmployeeProfileController employeeProfileController;
	
	@BeforeEach
	public void setupUp() {
		employeeModel=new EmployeeModel(
					1,
					   "Aditya",
					    "Male",
					    "A4",
					     "BE",
					     "JFS",
					    "BULT",
					    "ABC",
					    "abc@capgemini.com",
					     "dypcoe",
					     "abc@gmail.com",
					    "JFS",
					    "CS",
					    "March",
					     "April",
					    date,
					    date,
					    (long) 1234567890);
		 mockMvc= MockMvcBuilders.standaloneSetup(employeeProfileController).build();

	}
	
	@Test
	public void addEmployeeProfileController() throws JsonProcessingException, Exception {
		when(employeeProfileService.addEmployeeDetails(any())).thenReturn(employeeModel);
		mockMvc.perform(post("/api/pro/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(employeeModel)))
				.andExpect(status().isCreated());
				verify(employeeProfileService,times(1)).addEmployeeDetails(any());
		
	}
	
	@Test
	public void getEmployeeProfileController() throws JsonProcessingException, Exception {
		when(employeeProfileService.getallEmployeeDetails()).thenReturn(aList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/pro/getall")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJSONString(employeeModel)))
		.andDo(MockMvcResultHandlers.print());
		verify(employeeProfileService,times(1)).getallEmployeeDetails();
	}
	
	
	
	@Test
	public void updateEmployeeProfileController() throws JsonProcessingException, Exception {
		when(employeeProfileService.updateEmployeeDetails(any())).thenReturn(employeeModel);
		mockMvc.perform((MockMvcRequestBuilders.put("/api/pro/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(employeeModel))))
				.andExpect(status().isOk());
				verify(employeeProfileService,times(1)).updateEmployeeDetails(any());
		
	}
	

	private String asJSONString(EmployeeModel employeeModel2) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(employeeModel2);
	}

}
