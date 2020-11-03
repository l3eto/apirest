package com.apirest.ApiRest.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.apirest.ApiRest.model.EmployeeEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> 
{

    @Query("SELECT T FROM EmployeeEntity T")
    List<EmployeeEntity> getAllEmployees();
    
    @Modifying
    @Query(value = "INSERT INTO EMPLOYEE (ID, NAME, SURNAME, BIRTHDATE, SALARY) VALUES (:id, :name, :surname, :birthdate, :salary)", nativeQuery = true)
    @Transactional
    void createEmployee(Long id, String name, String surname, Date birthdate, BigDecimal salary);

    @Query("SELECT COALESCE(MAX(T.id), 0) FROM EmployeeEntity T")
    Long getMaxId();
    
}
