package com.example.thiscompany.controller;

import com.example.thiscompany.model.Office;
import com.example.thiscompany.request.OfficeCreationRQ;
import com.example.thiscompany.request.OfficeReturnRQ;
import com.example.thiscompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class OfficeController {

    @Autowired
    OfficeService officeService;

    //Get all offices
    @GetMapping("/getOffices")
    public List<Office> getOfficeById() {
        return officeService.findAll();
    }

    //Get office by id
    @GetMapping("/getOfficeById/{id}")
    public OfficeReturnRQ getOfficeById(@PathVariable(value = "id") Long id) {
        Office office = officeService.findById(id);
        OfficeReturnRQ officeReturnRQ = new OfficeReturnRQ();
        officeReturnRQ.setId(office.getId());
        officeReturnRQ.setLocation(office.getLocation());
        return officeReturnRQ;
    }

    //Create office
    @PostMapping(value = "/createOffice", consumes = "application/json", produces = "application/json")
    public OfficeReturnRQ createOffice(@RequestBody OfficeCreationRQ officerq) {
        Office newOffice = Office.builder()
                .location(officerq.getLocation())
                .build();
        officeService.save(newOffice);
        return new OfficeReturnRQ(
                newOffice.getId(),
                newOffice.getLocation());
    }

    //Update office
    @PutMapping(value = "updateOffice/{id}", consumes = "application/json", produces = "application/json")
    public OfficeReturnRQ updateOffice(@PathVariable(value = "id") Long id, @RequestBody OfficeCreationRQ officeCreationRQ) {
        Office office = officeService.update(id, officeCreationRQ.getLocation());
        OfficeReturnRQ officeReturnRQ = new OfficeReturnRQ(
                id,
                office.getLocation());
        return officeReturnRQ;
    }

    //Delete Employee
    @DeleteMapping(value = "/deleteOffice/{id}")
    public void deleteEmployee(Long id) {
        officeService.deleteById(id);
    }

}
