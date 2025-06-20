package com.example.employee.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class    Student {

   @Id
    private int Roll_num;

    private  String Name;

    @ManyToMany
    @JoinTable(
            name = "Student_course",
            joinColumns = @JoinColumn(name = "Stu_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Courses> courses = new ArrayList<>();
    public Student() {
    }

    public Student(int roll_num, String name, List<Courses> courses) {
        Roll_num = roll_num;
        Name = name;
        this.courses = courses;
    }

    public int getRoll_num() {
        return Roll_num;
    }

    public void setRoll_num(int roll_num) {
        Roll_num = roll_num;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
