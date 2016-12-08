package com.example.dto;

import java.util.List;

public class EmployeeDTO {
	
	private String fullName;
	private List<AddressDTO> addresse;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<AddressDTO> getAddresse() {
		return addresse;
	}

	public void setAddresse(List<AddressDTO> addresse) {
		this.addresse = addresse;
	}

	

}
