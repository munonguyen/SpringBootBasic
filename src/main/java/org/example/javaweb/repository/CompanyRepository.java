package org.example.javaweb.repository;

import org.example.javaweb.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
