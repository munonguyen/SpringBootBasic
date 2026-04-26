package org.example.javaweb.Controller;


import org.example.javaweb.repository.CompanyRepository;
import org.example.javaweb.repository.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value="/{id}")
    public String getCompanyById(@PathVariable(value="id")Long id, Model model){
        Company company = companyRepository.getById(id);
        model.addAttribute("company",company);
        model.addAttribute("employees",company.getEmployees());
        return "CompanyDetails";
    }
}
