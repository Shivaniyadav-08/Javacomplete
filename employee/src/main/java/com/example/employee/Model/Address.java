package com.example.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private int houseNum;
    private String street;
    private String city;
    private  String country;

    @ManyToOne()
   private Person1 person1;

    public Address() {
    }

    public Address(int houseNum, String street, String city, String country, Person1 person1) {
        this.houseNum = houseNum;
        this.street = street;
        this.city = city;
        this.country = country;
        this.person1 = person1;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person1 getPerson1() {
        return person1;
    }

    public void setPerson1(Person1 person1) {
        this.person1 = person1;
    }
}
