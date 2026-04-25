package org.example.javaweb.Controller;


import org.example.javaweb.Repository.EmployeeRepository;
import org.example.javaweb.Repository.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value="/")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees",employees);
        return "EmployeeList";
    }
    @RequestMapping(value="/detail/{id}")
    public String getEmployeegetById(@PathVariable(value="id")Long id,Model model){
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employeee",employee);
        return "EmployeeList";

    }


}
