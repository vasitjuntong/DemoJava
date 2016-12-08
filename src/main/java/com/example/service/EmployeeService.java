package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Address;
import com.example.domain.Employee;
import com.example.dto.AddressDTO;
import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeRegisterDTO;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private AddressRepository addressRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}

	public List<EmployeeDTO> getEmployeeAddress() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<AddressDTO> addressDTOs = null;
		EmployeeDTO employeeDTO = null;
		AddressDTO addressDTO = null;
		List<Employee> employees = employeeRepository.findAll();
		if (employees != null) {
			for (Employee employee : employees) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setFullName(employee.getFirstName() + " " + employee.getLastName());
				
				List<Address> addresses = addressRepository.findByEmpId(employee.getEmpId());
				addressDTOs =  new ArrayList<AddressDTO>();
				if (addresses != null && !addresses.isEmpty()) {					
					for (Address address : addresses) {
						addressDTO = new AddressDTO();
						addressDTO.setAddress(address.getAddress1());
						addressDTO.setPostal(address.getPostal());
						addressDTOs.add(addressDTO);
					}					
				}
				employeeDTO.setAddresse(addressDTOs);
				employeeDTOs.add(employeeDTO);
			}
		}
		
		return employeeDTOs;

	}

	public Integer saveOrUpdateEmployee(EmployeeRegisterDTO employeeRegisterDTO) {
		Employee employee = new Employee();
		employee.setEmpId(employeeRegisterDTO.getEmpId());
		employee.setFirstName(employeeRegisterDTO.getFirstName());
		employee.setLastName(employeeRegisterDTO.getLastName());
		return employeeRepository.saveAndFlush(employee).getEmpId();

	}
}
