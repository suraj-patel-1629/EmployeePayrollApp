package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    // Injecting EmployeeRepo class
    @Autowired
    private EmployeeRepo employeeRepo;

    // Service to save employee to DB
    public ResponseEntity<Employee> postEmployeeData(EmployeeDto dto) {
        Employee emp = new Employee(0, dto.getName(), dto.getSalary(), dto.getDepartment());
        Employee savedEmployee = employeeRepo.save(emp);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // 201 Created
    }

    // Service to get all employees
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<Employee> allEmp = employeeRepo.findAll();
        List<EmployeeDto> allEmpDto = new ArrayList<>();

        for (Employee emp : allEmp) {
            EmployeeDto empDto = new EmployeeDto(emp.getName(), emp.getSalary(), emp.getDepartment());
            allEmpDto.add(empDto);
        }

        if (allEmpDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allEmpDto, HttpStatus.OK);
    }

    // Service to get employee by ID
    public ResponseEntity<EmployeeDto> getEmployeeById(Integer id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));;


        EmployeeDto empDto = new EmployeeDto(emp.getName(), emp.getSalary(), emp.getDepartment());
        return new ResponseEntity<>(empDto, HttpStatus.OK);
    }

    // Service to update employee data
    public ResponseEntity<EmployeeDto> updateEmployee(Integer id, EmployeeDto updateEmp) {
        Optional<Employee> emp = employeeRepo.findById(id);

        if (emp.isPresent()) {
            Employee existingEmployee = emp.get();
            existingEmployee.setName(updateEmp.getName());
            existingEmployee.setDepartment(updateEmp.getDepartment());
            existingEmployee.setSalary(updateEmp.getSalary());

            Employee updatedEmployee = employeeRepo.save(existingEmployee);
            EmployeeDto responseDto = new EmployeeDto(updatedEmployee.getName(), updatedEmployee.getSalary(), updatedEmployee.getDepartment());

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Service to delete employee from DB
    public ResponseEntity<String> deleteEmp(Integer id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found please provide correct ID"));

            employeeRepo.deleteById(id);
            return new ResponseEntity<>("Employee with ID: " + id + " deleted from DB", HttpStatus.OK);


    }
}
