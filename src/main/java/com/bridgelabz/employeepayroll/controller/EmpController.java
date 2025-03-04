package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.EmpService;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private IEmployeeService iEmployeeService;

    // API to get all employees
    @GetMapping("/getall")
    public ResponseEntity<List<EmployeeDto>> getAllEmp() {
        log.info("Fetching all employees");
        return iEmployeeService.getAllEmployee();
    }

    // API to create employee
    @PostMapping("/post")
    public ResponseEntity<Employee> postEmployee(@Valid @RequestBody EmployeeDto emp) {
        log.info("Creating new employee");
        return iEmployeeService.postEmployeeData(emp);
    }

    // API to get employee by their ID
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        log.info("Fetching details of employee with ID: " + id);
        return iEmployeeService.getEmployeeById(id);
    }

    // API to update employee details
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id, @Valid @RequestBody EmployeeDto updateEmp) {
        log.info("Updating employee with ID: " + id);
        return iEmployeeService.updateEmployee(id, updateEmp);
    }

    // API to delete employee from DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Integer id) {
        log.info("Deleting employee with ID: " + id);
        return iEmployeeService.deleteEmp(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> findEmployeeByDepartment(@PathVariable String department){
        List<Employee> empDataList = null;
        empDataList= iEmployeeService.findEmployeeByDepartment(department);
        return empDataList;
    }
}
