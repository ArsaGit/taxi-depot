package com.example.taxidepot.config;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDbConfig {
    HttpClient httpClient = new StdHttpClient.Builder()
            .host("localhost")
            .port(5984)
            .username("root")
            .password("1234")
            .build();
    CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
    // - - - - - - - - Creating database - - - - - - - - - - - - - - //
//    @Autowired
//    CouchDbConnector db = new StdCouchDbConnector("couchdb-dev", dbInstance);

    @Bean("couchdb-dev")
    public CouchDbConnector couchDbConnector() {
        return new StdCouchDbConnector("couchdb-dev", dbInstance);
    }
}
