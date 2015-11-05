package org.lemanoman.buscaendereco.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lemanoman.buscaendereco.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

public interface EmployeeService {
    public Employee save(@NotNull @Valid final Employee employee);
    public List<Employee> getList();
}
