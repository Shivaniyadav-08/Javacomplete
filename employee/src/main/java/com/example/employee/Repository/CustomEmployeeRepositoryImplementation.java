package com.example.employee.Repository;

import com.example.employee.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomEmployeeRepositoryImplementation implements CustomEmployeeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findByName(String name) {
        //jpql query
        String jpql = "select e from Employee e where e.name = :name";

        // typed query
        TypedQuery<Employee> query = entityManager.createQuery(jpql,Employee.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
