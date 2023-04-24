package com.example.taxidepot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DriverLicense extends CouchDbDocument {
    @TypeDiscriminator
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String birthplace;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String issuedBy;
    private String code;
    private String residence;
    private String categories;

    public DriverLicense() {
        this.fullName = "";
        this.birthdate = new Date();
        this.birthplace = "";
        this.issueDate = new Date();
        this.expirationDate = new Date();
        this.issuedBy = "";
        this.code = "";
        this.residence = "";
        this.categories = "";
    }

    public DriverLicense(String fullName, Date birthdate, String birthplace, Date issueDate, Date expirationDate,
                         String issuedBy, String code, String residence, String categories) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.issuedBy = issuedBy;
        this.code = code;
        this.residence = residence;
        this.categories = categories;
    }

    public DriverLicense(@JsonProperty("fullName") String fullName, @JsonProperty("birthdate") Date birthdate,
                         @JsonProperty("birthplace") String birthplace, @JsonProperty("issueDate") Date issueDate,
                         @JsonProperty("expirationDate") Date expirationDate, @JsonProperty("issuedBy") String issuedBy,
                         @JsonProperty("code") String code, @JsonProperty("residence") String residence,
                         @JsonProperty("categories") String categories,
                         @JsonProperty("_id") String _id, @JsonProperty("_rev") String _rev) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.issuedBy = issuedBy;
        this.code = code;
        this.residence = residence;
        this.categories = categories;
        this.setId(_id);
        this.setRevision(_rev);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
