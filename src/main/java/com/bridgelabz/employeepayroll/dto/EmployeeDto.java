package com.bridgelabz.employeepayroll.dto;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
 @NotBlank(message = "Name is required and cannot be empty")
 @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and contain only alphabets")
 private String name;
 @NotNull(message = "salary should not be blank")
 @Min(value = 500,message = "salary should be greater than 500")
 private double salary;


 private String department;
 private String profilePic;
 private String gender;
 private LocalDate startDate;

 private String note;


//    public EmployeeDto(String name, double salary, String department) {
//        this.name = name;
//        this.salary = salary;
//        this.department = department;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
}
