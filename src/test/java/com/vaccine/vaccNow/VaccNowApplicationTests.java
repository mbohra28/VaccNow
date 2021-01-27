package com.vaccine.vaccNow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaccine.vaccNow.controller.AvailabilityController;
import com.vaccine.vaccNow.repository.IBranchRepository;
import com.vaccine.vaccNow.repository.IVaccineRepository;
import com.vaccine.vaccNow.service.IBranchService;

//@SpringBootTest
@WebMvcTest(AvailabilityController.class)
@ActiveProfiles("test")
class VaccNowApplicationTests {
	@MockBean 
	IBranchService service;
	
	@MockBean
	IBranchRepository branchRepo;

	@MockBean
	IVaccineRepository vaccineRepo;
	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper mapper;
	
	@Test
	void getAllVaccinesPerBranch() throws Exception {
		//String expectedResult = "[\"Coronil\"]";
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllVaccinesPerBranch").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200))
		;
	}

}
