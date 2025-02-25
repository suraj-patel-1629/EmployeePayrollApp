package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.dto.EmployeeDto;
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
    public Employee postEmployeeData(EmployeeDto dto){
        Employee emp = new Employee(dto.getName(), dto.getSalary(), dto.getDepartment());
        return employeeRepo.save(emp);
    }
    // service to get all employee
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> allEmp = employeeRepo.findAll();
        List<EmployeeDto> allEmpDto = new ArrayList<>();
        for(Employee emp : allEmp){
            EmployeeDto empDto = new EmployeeDto(emp.getName(),emp.getSalary(),emp.getDepartment());
            allEmpDto.add(empDto);
        }
        return allEmpDto;

    }
    // service to get employee by id
    public EmployeeDto getEmployeeById(Integer id){
        Employee emp = employeeRepo.findById(id).orElse(null);
        if (emp == null) {
            return null;
        }
        return new EmployeeDto(emp.getName(),emp.getSalary(),emp.getDepartment());
    }

    // service to update employee data
    public EmployeeDto updateEmployee(Integer id,EmployeeDto updateEmp){
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp!=null) {
            emp.setName(updateEmp.getName());
            emp.setDepartment(updateEmp.getDepartment());
            emp.setSalary(updateEmp.getSalary());
            Employee updateEmployee = employeeRepo.save(emp);
            return new EmployeeDto(updateEmployee.getName(), updateEmp.getSalary(), updateEmp.getDepartment());
        }
        else{
           return null;
        }
    }
    // service to delete employee from db
  public String deleteEmp(Integer id){
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp!=null){
            employeeRepo.deleteById(id);
            return "Employe with id : "+id+" deleted from DB";
        }
        else{
            return "Employee not found";
        }

  }

}
