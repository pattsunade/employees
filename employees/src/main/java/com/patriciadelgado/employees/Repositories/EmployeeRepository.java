package com.patriciadelgado.employees.Repositories;

import java.util.List;

import com.patriciadelgado.employees.Models.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
     List<Employee> findAll();
}
