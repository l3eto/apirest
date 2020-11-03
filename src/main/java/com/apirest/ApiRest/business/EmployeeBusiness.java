package com.apirest.ApiRest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apirest.ApiRest.model.EmployeesDto;
import com.apirest.ApiRest.model.EmployeeDto;
import com.apirest.ApiRest.services.EmployeeService;

@Component
public class EmployeeBusiness {

	@Autowired
	EmployeeService employeeService;

	public EmployeesDto getEmployees() {
		return employeeService.getEmployees();
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}
	
}
