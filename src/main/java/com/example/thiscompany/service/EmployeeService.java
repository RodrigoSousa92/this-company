package com.example.thiscompany.service;

import com.example.thiscompany.exception.EmployeeNotFound;
import com.example.thiscompany.exception.OfficeNotFound;
import com.example.thiscompany.model.Employee;
import com.example.thiscompany.model.Office;
import com.example.thiscompany.repository.EmployeeRepository;
import com.example.thiscompany.repository.OfficeRepository;
import com.example.thiscompany.request.EmployeeReturnRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OfficeRepository officeRepository;

    public EmployeeReturnRQ save(Employee employee, Long officeId) {
        Office office = officeRepository.findById(officeId).orElseThrow(OfficeNotFound::new);
        employee.setOffice(office);
        employeeRepository.save(employee);
        EmployeeReturnRQ employeeReturnRQ = new EmployeeReturnRQ();
        employeeReturnRQ.setAge(employee.getAge());
        employeeReturnRQ.setName(employee.getName());
        employeeReturnRQ.setLastname(employee.getLastname());
        employeeReturnRQ.setSalary(employee.getSalary());
        employeeReturnRQ.setOfficeId(employee.getOffice().getId());
        employeeReturnRQ.setOfficeLocation(employee.getOffice().getLocation());
        return employeeReturnRQ;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Long id, String name, String lastname, int age, float salary, long officeId) {
        Employee employee = this.findById(id);
        Office office = officeRepository.findById(officeId).orElseThrow(OfficeNotFound::new);
        employee.setName(name);
        employee.setLastname(lastname);
        employee.setSalary(salary);
        employee.setAge(age);
        employee.setOffice(office);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long aLong) {
        return employeeRepository.findById(aLong).orElseThrow((EmployeeNotFound::new));
    }

    public void deleteById(Long id) {
        this.findById(id);
        employeeRepository.deleteById(id);
    }
}