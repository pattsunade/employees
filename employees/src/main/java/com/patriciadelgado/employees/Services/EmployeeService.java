package com.patriciadelgado.employees.Services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.employees.Models.Employee;
import com.patriciadelgado.employees.Repositories.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            return null;
        }
    }

    public Employee createEmployee(Employee e) {
        return employeeRepository.save(e);
    }
    
}
