package com.patriciadelgado.employees.Controllers;

import javax.validation.Valid;

import com.patriciadelgado.employees.Models.Employee;
import com.patriciadelgado.employees.Services.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employees/new/{id}")
    public String newEmployee(@PathVariable("id") Long id, 
    @ModelAttribute("employee") Employee employee, Model model) {
        Employee employees = employeeService.findEmployee(id);
        model.addAttribute("manager", employees);
        return "/newEmployee.jsp";
    }

    @PostMapping("/employees/new/{id}")
    public String createEmployee(@PathVariable("id") Long id,
    @Valid @ModelAttribute("employee")Employee employee, 
            BindingResult result) {
        if (result.hasErrors()) {
            return "/newEmployee.jsp";
        } else {
            Employee manager = employeeService.findEmployee(id);
            employee.setManager(manager);
            employeeService.createEmployee(employee);
            return "redirect:/employees/new/"+ id;
        }
    }
    @GetMapping("/managers/new")
    public String newManager(@ModelAttribute("employee") Employee employee) {
        return "/newManager.jsp";
    }
     @PostMapping("/managers/new")
    public String createManager(
    @Valid @ModelAttribute("employee")Employee employee, 
            BindingResult result) {
        if (result.hasErrors()) {
            return "/newManager.jsp";
        } else {
            employeeService.createEmployee(employee);
            return "redirect:/employees/new/"+ employee.getId();
        }
     }
}
