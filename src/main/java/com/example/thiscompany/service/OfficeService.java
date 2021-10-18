package com.example.thiscompany.service;

import com.example.thiscompany.exception.OfficeNotFound;
import com.example.thiscompany.model.Office;
import com.example.thiscompany.model.OfficeLocation;
import com.example.thiscompany.repository.EmployeeRepository;
import com.example.thiscompany.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Office update(Long id, OfficeLocation location) {
        Office office = this.findById(id);
        office.setLocation(location);
        return officeRepository.save(office);
    }

    public Office findById(Long aLong) {
        return officeRepository.findById(aLong).orElseThrow((OfficeNotFound::new));
    }

    public <S extends Office> S save(S entity) {
        return officeRepository.save(entity);
    }

    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    public void deleteById(Long id) {
        this.findById(id);
        officeRepository.deleteById(id);
    }
}

