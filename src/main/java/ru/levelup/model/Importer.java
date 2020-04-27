package ru.levelup.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

// Организация - Импортер
@Entity
public class Importer {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "importer")
    private List<Document> documents;

    @Column(nullable = false)
    private String importerName; // Название организации или ФИО ИП

    @Column(nullable = false)
    private String inn; // ИНН

    @Column(nullable = false)
    private String country; // Страна

    @Column(nullable = false)
    private String city; // Город

    @Column(nullable = false)
    private String streetHouse; // Адрес

    @Column(nullable = false)
    private String headFIO; // ФИО руководителя организации

    @Column(nullable = false)
    private String accountantFIO; // ФИО бухгалтера

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getINN() {
        return inn;
    }

    public void setINN(String inn) {
        this.inn = inn;
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