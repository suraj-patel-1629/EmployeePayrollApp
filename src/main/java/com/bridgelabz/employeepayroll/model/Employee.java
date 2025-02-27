package com.bridgelabz.employeepayroll.model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;
    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;
    private LocalDate startDate;
    private String gender;
    private String profilePic;
    private String note;


//    Employee(){
//
//    }
//
//    public Employee(String name, double salary, String department) {
//        this.name = name;
//        this.salary = salary;
//        this.department = department;
//    }
//
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
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

}
