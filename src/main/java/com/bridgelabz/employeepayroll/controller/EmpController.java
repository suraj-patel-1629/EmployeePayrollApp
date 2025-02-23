package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.EmployeePayRollApplication;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    // injecting EmpService class
    @Autowired
    private EmpService service;

    // Api to get all employee
    @GetMapping("/getall")
    public List<Employee> getAllEmp(){
        return service.getAllEmployee();
    }
    // Api to create employee
    @PostMapping("/post")
    public Employee postEmployee(@RequestBody Employee emp){
        return service.postEmployeeData(emp);
    }
    // Api to get employee by their id
    @GetMapping("/getbyid/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }
    // Api to update employee detail
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable(required = true) Integer id,@RequestBody(required = true) Employee updateEmp){
        return service.updateEmployee(id,updateEmp);
    }
    // Api to delete employee from db
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable Integer id){
        return service.deleteEmp(id);
    }

}
