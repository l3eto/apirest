package com.apirest.ApiRest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apirest.ApiRest.business.EmployeeBusiness;
import com.apirest.ApiRest.model.EmployeesDto;
import com.apirest.ApiRest.model.EmployeeDto;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController 
{
    @Autowired
    private EmployeeBusiness employeeBusiness;

    @GetMapping("/all")
	public EmployeesDto getEmployees() {
		return employeeBusiness.getEmployees();
    }
    
    @PostMapping("/create")
	public EmployeeDto distanceRoute(@RequestBody EmployeeDto request) {
		return employeeBusiness.createEmployee(request);
	}

}
