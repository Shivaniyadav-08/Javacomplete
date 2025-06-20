package com.example.employee;

import com.example.employee.Model.Courses;
import com.example.employee.Model.Student;
import com.example.employee.Repository.CoursesRepo;
import com.example.employee.Repository.Studentrepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {

	  SpringApplication.run(EmployeeApplication.class, args);

	/* Studentrepo studentrepo = context.getBean(Studentrepo.class);
	 CoursesRepo coursesRepo = context.getBean(CoursesRepo.class);

	 Courses c1 = new Courses();
	 c1.setCourse_id(101);
	 c1.setCourse_name("java");

	 Courses c2 = new Courses();
	 c2.setCourse_id(102);
	 c2.setCourse_name("Python");

	 coursesRepo.save(c1);
	 coursesRepo.save(c2);

	 Student s1 = new Student();
	 s1.setRoll_num(1);
	 s1.setName("Shivani");

	 studentrepo.save( s1);*/
	}

}
