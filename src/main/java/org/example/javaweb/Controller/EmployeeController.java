package org.example.javaweb.Controller;


import org.example.javaweb.repository.CompanyRepository;
import org.example.javaweb.repository.EmployeeRepository;
import org.example.javaweb.repository.entity.Company;
import org.example.javaweb.repository.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value="/")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeRepository.findAll();
        List<Company> companies = companyRepository.findAll();

        model.addAttribute("employees",employees);
        return "EmployeeList";
    }
    @RequestMapping(value="/detail/{id}")
    public String getEmployeegetById(@PathVariable(value="id")Long id,Model model){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("employees", List.of(employee.get()));
        return "EmployeeList";

    }

    @GetMapping(value="/update/{id}")
    public String updateEmployee(@PathVariable(value="id") Long id,Model model){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("employee", employee.get());
        return "EmployeeUpdate";
    }

    @PostMapping(value="/save")
    public String saveEmployee(Employee employee, @RequestParam(value = "companyId", required = false) Long companyId){
        if (companyId != null) {
            companyRepository.findById(companyId).ifPresent(employee::setCompany);
        }
        employeeRepository.save(employee);
        return "redirect:/detail/" + employee.getId();
    }
    @GetMapping(value="/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies",companies);
        model.addAttribute("employee",employee);
        return "EmployeeAdd";
    }
    @RequestMapping(value="/insert")
    public String insertEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/detail/"+employee.getId();
    }
    @GetMapping(value="/delete/{id}")
    public String deleteEmployee(@PathVariable(value="id") Long id,Model model ){
        if(employeeRepository.findById(id).isPresent()){
            Employee employee = employeeRepository.findById(id).get();
            employeeRepository.delete(employee);

        }
        return "redirect:/";
    }



}
