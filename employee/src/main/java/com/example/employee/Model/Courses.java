package com.example.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {

   @Id
    private int course_id;
    private String course_name;

  @ManyToMany(mappedBy =  "courses")
   private List<Student> student= new ArrayList<>();

    public Courses() {

    }

    public Courses(int course_id, String course_name, List<Student> student) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.student = student;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
