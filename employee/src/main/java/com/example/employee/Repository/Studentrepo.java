package com.example.employee.Repository;

import com.example.employee.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Studentrepo extends JpaRepository<Student,Integer> {

    @Query("select s from Student s")
     List<Student> getAllStudent();

    @Query(value = "select s from Student s where s.Name=:name")
     List<Student> getStudentByName(@Param("name") String name);

    @NativeQuery(value = "select * from Student ")
     List<Student> getStudent();


}
