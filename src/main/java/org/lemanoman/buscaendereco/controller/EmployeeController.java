package org.lemanoman.buscaendereco.controller;

import java.util.List;

import javax.inject.Inject;

import org.lemanoman.buscaendereco.model.EmployeeModel;
import org.lemanoman.buscaendereco.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Inject
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<EmployeeModel> listEmployees() {
        List<EmployeeModel> employees = employeeService.getList();
        return employees;
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public void addEmployee(@RequestParam(value = "employeeName", required = false) String employeeName,
    		@RequestParam(value = "employeeId", required = false) String employeeId,
    		@RequestParam(value = "employeeCity", required = false) String employeeCity){
    	EmployeeModel employee = new EmployeeModel(employeeId,employeeName,employeeCity);
    	employeeService.save(employee);
    }
}
