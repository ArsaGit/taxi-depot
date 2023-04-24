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

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void createDriverLicense(DriverLicense driverLicense) {
        driverLicenseService.addDriverLicense(driverLicense);
    }
}
