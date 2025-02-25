package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.EmployeePayRollApplication;
import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {
    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
    // injecting EmpService class
    @Autowired
    private EmpService service;

    // Api to get all employee
    @GetMapping("/getall")
    public List<EmployeeDto> getAllEmp(){
        log.info("All employee List endpoint called ");
        return service.getAllEmployee();
    }
    // Api to create employee
    @PostMapping("/post")
    public Employee postEmployee(@RequestBody EmployeeDto emp){

        log.info("member created endpoint called ");
        return service.postEmployeeData(emp);
    }
    // Api to get employee by their id
    @GetMapping("/getbyid/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id){
        log.info("fetching detail of employee no : "+id);
        return service.getEmployeeById(id);
    }

    // Api to update employee detail
    @PutMapping("/update/{id}")
    public EmployeeDto updateEmployee(@PathVariable(required = true) Integer id,@RequestBody(required = true) EmployeeDto updateEmp){
        log.info("Employee with id "+id+" updated");
        return service.updateEmployee(id,updateEmp);
    }
    // Api to delete employee from db
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable Integer id){
        log.info("Employee with ID no "+id+ " deleted");
        return service.deleteEmp(id);
    }

}
