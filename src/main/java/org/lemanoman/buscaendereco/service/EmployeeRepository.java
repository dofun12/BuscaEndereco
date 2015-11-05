package org.lemanoman.buscaendereco.service;

import org.lemanoman.buscaendereco.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    
}
