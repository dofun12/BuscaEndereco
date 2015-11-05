package org.lemanoman.buscaendereco.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lemanoman.buscaendereco.model.EmployeeModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

public interface EmployeeService {
    public EmployeeModel save(@NotNull @Valid final EmployeeModel employee);
    public List<EmployeeModel> getList();
}
