package com.apirest.ApiRest.services;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.apirest.ApiRest.repository.EmployeeRepository;
import com.apirest.ApiRest.model.EmployeeDto;
import com.apirest.ApiRest.model.EmployeeEntity;
import com.apirest.ApiRest.model.EmployeesDto;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public EmployeesDto getEmployees() {
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		employeeRepository.getAllEmployees().stream().forEach(employeeEntity -> {
			employeeDtoList.add(fromEntityToDto(employeeEntity));
		});
		return new EmployeesDto(employeeDtoList);
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Long newId = employeeRepository.getMaxId() + 1;
		EmployeeEntity employeeEntity = fromDtoToEntity(employeeDto);
		employeeEntity.setId(newId);
		employeeRepository.createEmployee(
			employeeEntity.getId(),
			employeeEntity.getName(), 
			employeeEntity.getSurname(), 
			employeeEntity.getBirthDate(), 
			employeeEntity.getSalary()
		);
		return fromEntityToDto(employeeEntity);
	}

	private EmployeeEntity fromDtoToEntity(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		if (employeeDto.getId() != null) {
			employeeEntity.setId(Long.parseLong(employeeDto.getId(), 10));
		}
		employeeEntity.setName(employeeDto.getName());
		employeeEntity.setSurname(employeeDto.getSurname());
		if (employeeDto.getBirthDate() != null) {
			try {
				employeeEntity.setBirthDate(DATE_FORMAT.parse(employeeDto.getBirthDate()));
			} catch (Exception e) {}
		}
		if (employeeDto.getSalary() != null) {
			employeeEntity.setSalary(new BigDecimal(employeeDto.getSalary()));
		}
		return employeeEntity;
	}


	private EmployeeDto fromEntityToDto(EmployeeEntity employeeEntity) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employeeEntity.getId().toString());
		employeeDto.setName(employeeEntity.getName());
		employeeDto.setSurname(employeeEntity.getSurname());
		employeeDto.setBirthDate(DATE_FORMAT.format(employeeEntity.getBirthDate()));
		employeeDto.setSalary(employeeEntity.getSalary().toPlainString());
		return employeeDto;
	}

}
