package com.example.taxidepot.repo;


import com.example.taxidepot.model.DriverLicense;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
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
