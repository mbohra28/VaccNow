package com.vaccine.vaccNow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

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
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaccine.vaccNow.controller.AvailabilityController;
import com.vaccine.vaccNow.model.Branch;
import com.vaccine.vaccNow.model.Vaccine;
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
	
	String expectedResult = "[\"Coronil\"]";
	
	@Test
	void getAllVaccinesPerBranch() throws Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllVaccinesPerBranch").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}

	
	
	  @Test 
	  void getAllVaccinesPerfromBranchFail() throws Exception { 

		  Mockito.when(branchRepo.findOneById(Mockito.anyInt())).thenReturn(null);
	      List<Vaccine> vc =service.getVaccinePerBranch();
	      assertEquals(vc.equals(null),false);
	  }
	  
	  @Test 
	  void getAllVaccinesPerfromBranchSuccess() throws Exception { 
		 
		  Mockito.when(branchRepo.findOneById(Mockito.anyInt())).thenReturn(new Branch());
	      List<Vaccine> vc =service.getVaccinePerBranch();
	      assertEquals(vc.size()==0,true);
	  }
	  
	  @Test 
	  void getAllVaccinesPerfromBranchSuccess1() throws Exception { 
		 
		 System.out.println(getAvailableVaccine());
		  Mockito.when(branchRepo.findById(1).get().getVaccineList()).thenReturn(getAvailableVaccine());
	      List<Vaccine> vc =service.getVaccinePerBranch();
	      assertEquals(vc.equals(null),false);
	  }
	  
	  List<Vaccine> getAvailableVaccine() throws JsonMappingException, JsonProcessingException
	  {
		  
		  ObjectMapper ob=new ObjectMapper();
		  
		  String str="[{\"vaccineId\":2,\"vaccineName\":\"Janssen\",\"branch\":{\"branchId\":1,\"branchName\":\"Sion\"},\"availableVaccine\":2,\"date\":\"\"}]";
		  return ob.readValue(str, new TypeReference<List<Vaccine>>() {
		});
	  }
	 
	 

}
