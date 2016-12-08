package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByEmpId(Integer empId);
}
