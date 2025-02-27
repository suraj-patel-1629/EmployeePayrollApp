package com.bridgelabz.employeepayroll.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

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

 @NotEmpty(message = "Department cannot be empty")
 private List<String> department;

 @NotBlank(message = "ProfilePic cannot be null")
 private String profilePic;
 @NotBlank(message = "Gender cannot be null")
 @Pattern(regexp = "(Male|Female|Other)$",message = "Gender must be male female and  other")
 private String gender;
 @NotNull(message = "start date is requires")
 @JsonFormat(pattern = "dd MMM yyy")
 @PastOrPresent(message = "StartDate should be present or past")
 private LocalDate startDate;

 @NotBlank(message = "Note cannot be Empty")
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
