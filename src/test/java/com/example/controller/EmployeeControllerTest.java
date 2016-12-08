package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.dto.EmployeeDTO;
import com.example.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void getEmployees() throws Exception {
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFullName("test test");
		employeeDTO.setAddresse(null);
		employees.add(employeeDTO);
		
		Mockito.when(employeeService.getEmployeeAddress()).thenReturn(employees);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/v1/employee")
				.contentType(MediaType.APPLICATION_JSON);

		this.mockMvc.perform(builder)
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].fullName", Matchers.equalTo("test test")))
			.andExpect(MockMvcResultMatchers.status().isOk());
		
//		Mockito.verify(employeeService).getEmployeeAddress();
	}
	
		
	
	
}
