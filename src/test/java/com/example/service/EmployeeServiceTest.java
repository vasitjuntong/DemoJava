package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.domain.Employee;
import com.example.dto.EmployeeDTO;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmployeeServiceTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;	
	@Mock
	private AddressRepository addressRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeService).build();
	}
	
	public void getEmployeeAddress() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setFirstName("firstName");
		employee.setLastName("lastName");
		employees.add(employee);
		
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		Mockito.when(addressRepository.findByEmpId(Matchers.anyInt())).thenReturn(null);
		
	}
}
