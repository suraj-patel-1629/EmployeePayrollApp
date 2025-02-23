package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpService {
 //injecting EmployeeRapo class
    @Autowired
    private EmployeeRepo employeeRepo;
    //service to save employee to db
    public Employee postEmployeeData(Employee emp){

        return employeeRepo.save(emp);
    }
    // service to get all employee
    public List<Employee> getAllEmployee(){
        List<Employee> allEmp = employeeRepo.findAll();
        return allEmp;

    }
    // service to get employee by id
    public Employee getEmployeeById(Integer id){
        return employeeRepo.findById(id).orElse(null);
    }

    // service to update employee data
    public Employee updateEmployee(Integer id,Employee updateEmp){
        Employee emp = getEmployeeById(id);
        if(emp!=null) {
            emp.setName(updateEmp.getName());
            emp.setDepartment(updateEmp.getDepartment());
            emp.setSalary(updateEmp.getSalary());
            return employeeRepo.save(emp);
        }
        else{
           return null;
        }
    }
    // service to delete employee from db
  public String deleteEmp(Integer id){
        employeeRepo.deleteById(id);
        return "Employe with id : "+id+" deleted from DB";
  }

}
