package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    ResponseEntity<Employee> postEmployeeData(EmployeeDto dto);
    ResponseEntity<List<EmployeeDto>> getAllEmployee();
    ResponseEntity<EmployeeDto> getEmployeeById(Integer id);
    ResponseEntity<EmployeeDto> updateEmployee(Integer id, EmployeeDto updateEmp);
    ResponseEntity<String> deleteEmp(Integer id);
    List<Employee> findEmployeeByDepartment(String department);

}
