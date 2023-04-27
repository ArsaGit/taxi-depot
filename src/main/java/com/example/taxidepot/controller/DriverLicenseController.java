package com.example.taxidepot.controller;

import com.example.taxidepot.model.DriverLicense;
import com.example.taxidepot.service.DriverLicenseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverLicenseController {
    @Autowired
    private DriverLicenseService driverLicenseService;

    @GetMapping
    public List<DriverLicense> getDriverLicenses() {
        return driverLicenseService.getAll();
    }

    @GetMapping("/{id}")
    public DriverLicense getById(@PathVariable String id) {
        return driverLicenseService.getById(id);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateDriverLicense(@PathVariable String id, @RequestBody DriverLicense driverLicense) {
        DriverLicense dl = driverLicenseService.getById(id);
        if(driverLicense.getFullName() != "") dl.setFullName(driverLicense.getFullName());
        if(driverLicense.getBirthdate() != null) dl.setBirthdate(driverLicense.getBirthdate());
        if(driverLicense.getBirthplace() != "") dl.setBirthplace(driverLicense.getBirthplace());
        if(driverLicense.getIssueDate() != null) dl.setIssueDate(driverLicense.getIssueDate());
        if(driverLicense.getExpirationDate() != null) dl.setExpirationDate(driverLicense.getExpirationDate());
        if(driverLicense.getIssuedBy() != "") dl.setIssuedBy(driverLicense.getIssuedBy());
        if(driverLicense.getCategories() != "") dl.setCategories(driverLicense.getCategories());
        if(driverLicense.getCode() != "") dl.setCode(driverLicense.getCode());
        if(driverLicense.getResidence() != "") dl.setResidence(driverLicense.getResidence());
        driverLicenseService.updateDriverLicense(dl);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DriverLicense> createDriversLicense( @RequestBody DriverLicense driverLicense) {
        driverLicenseService.addDriverLicense(driverLicense);
        return ResponseEntity.ok(driverLicense);
    }

    @DeleteMapping("/{id}")
    public void deleteDriverLicense(@PathVariable String id) {
        driverLicenseService.deleteDriverLicense(id);
    }
}
