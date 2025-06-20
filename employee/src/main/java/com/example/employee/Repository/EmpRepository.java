package com.example.employee.Repository;

import com.example.employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmpRepository extends JpaRepository<Employee,Integer>, CustomEmployeeRepository {
        Employee findById(int id);

        // Derived method
        List<Employee> findByRole( String role);

        //JPQL query using @query
        @Query("select e from Employee e where e.salary>:salary")
        List<Employee> findEmployeeWithSalaryGreaterThan(@Param("salary") double salary);

        //wuth native
        @Query(value = "select * from employee e where age <:age", nativeQuery = true)
        List<Employee> findEmployeeWithAgeLessThanSomething(@Param("age") int age);


       @Query(value = "select * from GetEmployeeByMinSalary(:minSalary)", nativeQuery = true)
       List<Employee> getEmployeesByMinSalary( @Param("minSalary")double minSalary);

}
