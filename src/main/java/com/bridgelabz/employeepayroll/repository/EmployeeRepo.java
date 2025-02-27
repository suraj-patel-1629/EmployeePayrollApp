package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
 @Query(value = "select * from employee,employee_departments where employee_id=id and department =:department",nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String department);
}
