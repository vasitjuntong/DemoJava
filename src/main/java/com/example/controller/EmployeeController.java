package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeRegisterDTO;
import com.example.service.EmployeeService;

@Controller
@RequestMapping(value = "/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeDTO> getEmployees() {
        return service.getEmployeeAddress();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public String saveEmployee(@RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        System.out.println("employeeRegisterDTO -> " + employeeRegisterDTO.toString());
        return String.valueOf(service.saveOrUpdateEmployee(employeeRegisterDTO));
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Integer updateEmployee(@RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        System.out.println("employeeRegisterDTO -> " + employeeRegisterDTO.toString());
        return service.saveOrUpdateEmployee(employeeRegisterDTO);
    }

}
