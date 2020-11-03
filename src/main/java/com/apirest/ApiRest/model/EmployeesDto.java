package com.apirest.ApiRest.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDto
{
    private List<EmployeeDto> employeeDtoList;

    public EmployeesDto(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
    
    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }
 
    public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
}
