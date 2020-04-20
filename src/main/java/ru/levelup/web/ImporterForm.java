package ru.levelup.web;

import ru.levelup.model.Group;

import java.util.List;

public class ImporterForm {

    private String importerName;
    private String inn;
    private String PostalCode;
    private String country;
    private String city;
    private String streetHouse;
    private String headFIO;
    private String accountantFIO;


    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetHouse() {
        return streetHouse;
    }

    public void setStreetHouse(String streetHouse) {
        this.streetHouse = streetHouse;
    }

    public String getHeadFIO() {
        return headFIO;
    }

    public void setHeadFIO(String headFIO) {
        this.headFIO = headFIO;
    }

    public String getAccountantFIO() {
        return accountantFIO;
    }

    public void setAccountantFIO(String accountantFIO) {
        this.accountantFIO = accountantFIO;
    }
}
