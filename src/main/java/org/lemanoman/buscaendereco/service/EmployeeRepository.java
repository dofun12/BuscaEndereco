package org.lemanoman.buscaendereco.service;

import org.lemanoman.buscaendereco.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {
    
}
