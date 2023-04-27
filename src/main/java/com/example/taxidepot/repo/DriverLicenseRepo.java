package com.example.taxidepot.repo;


import com.example.taxidepot.model.DriverLicense;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverLicenseRepo extends CouchDbRepositorySupport<DriverLicense> {

    @Autowired
    public DriverLicenseRepo(@Qualifier("couchdb-dev") CouchDbConnector db) {
        super(DriverLicense.class, db);
        db.createDatabaseIfNotExists();
//        initStandardDesignDocument();
    }

    @GenerateView @Override
    public List<DriverLicense> getAll() {
        return queryView("new-view");
    }


}
