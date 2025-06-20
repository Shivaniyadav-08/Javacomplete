package com.example.employee.Model;

import jakarta.persistence.*;

@Entity
//@Table(name = "Employee")
@NamedStoredProcedureQuery(
        name = "Employee.getEmployeeByMinSalary",
        procedureName = "GetEmployeeByMinSalary",
        resultClasses = Employee.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "minSalary", type = Double.class)
        }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    private int age;
    private double salary;

    public Employee(int id, String name, String role, int age, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
