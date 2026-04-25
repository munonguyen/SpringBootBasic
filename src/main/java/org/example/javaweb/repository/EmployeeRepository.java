package org.example.javaweb.Repository;

import org.example.javaweb.Repository.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
