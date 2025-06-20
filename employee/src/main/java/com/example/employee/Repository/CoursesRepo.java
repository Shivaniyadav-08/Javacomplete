package com.example.employee.Repository;

import com.example.employee.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses,Integer> {

}
