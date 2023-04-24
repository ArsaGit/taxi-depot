package com.example.taxidepot.service;

import com.example.taxidepot.model.DriverLicense;
import com.example.taxidepot.repo.DriverLicenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLicenseService {
    @Autowired
    private DriverLicenseRepo driverLicenseRepo;

    public List<DriverLicense> getAll() {
        return driverLicenseRepo.getAll();
    }

    public DriverLicense addDriverLicense(DriverLicense driverLicense) {
        if(driverLicense.isNew()) {
            driverLicenseRepo.add(driverLicense);
        }
        return driverLicense;
    }

    public DriverLicense deleteDriverLicense(String id) {
        DriverLicense driverLicense = driverLicenseRepo.get(id);
        driverLicenseRepo.remove(driverLicense);
        return driverLicense;
    }

    public DriverLicense getById(String id) {
        DriverLicense driverLicense = driverLicenseRepo.get(id);
        return driverLicense;
    }
}
