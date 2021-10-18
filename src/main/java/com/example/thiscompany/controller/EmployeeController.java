package com.example.thiscompany.controller;

import com.example.thiscompany.model.Employee;
import com.example.thiscompany.request.EmployeeCreationRQ;
import com.example.thiscompany.request.EmployeeReturnRQ;
import com.example.thiscompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Get all employees
    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    //Get employee by id
    @GetMapping("/getEmployeeById/{id}")
    public EmployeeReturnRQ getEmployeeById(@PathVariable(value = "id") Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeReturnRQ employeeReturnRQ = new EmployeeReturnRQ();
        employeeReturnRQ.setAge(employee.getAge());
        employeeReturnRQ.setName(employee.getName());
        employeeReturnRQ.setLastname(employee.getLastname());
        employeeReturnRQ.setSalary(employee.getSalary());
        employeeReturnRQ.setOfficeId(employee.getOffice().getId());
        employeeReturnRQ.setOfficeLocation(employee.getOffice().getLocation());
        return employeeReturnRQ;
    }

    //Create employee
    @PostMapping(value = "createEmployee", consumes = "application/json", produces = "application/json")
    public EmployeeReturnRQ createEmployee(@RequestBody EmployeeCreationRQ employeerq) {
        Employee newEmployee = Employee.builder()
                .name(employeerq.getName())
                .lastname(employeerq.getLastname())
                .age(employeerq.getAge())
                .salary(employeerq.getSalary())
                .build();

        return employeeService.save(newEmployee, employeerq.getOfficeId());
    }

    //Update employee
    @PutMapping(value = "updateEmployee/{id}", consumes = "application/json", produces = "application/json")
    public EmployeeReturnRQ updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeCreationRQ employeeCreationRQ) {
        Employee employee = employeeService.update(id, employeeCreationRQ.getName(), employeeCreationRQ.getLastname(), employeeCreationRQ.getAge(), employeeCreationRQ.getSalary(), employeeCreationRQ.getOfficeId());
        EmployeeReturnRQ productResp = new EmployeeReturnRQ(
                id,
                employee.getName(),
                employee.getLastname(),
                employee.getAge(),
                employee.getSalary(),
                employee.getOffice().getId(),
                employee.getOffice().getLocation()
        );
        return productResp;
    }

    //Delete Employee
    @DeleteMapping(value = "/deleteEmployee/{id}")
    public void deleteEmployee(Long id) {
        employeeService.deleteById(id);
    }

}
