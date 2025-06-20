package com.example.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop1 {
    @Id
    private int laptop_id;
    private  String modelNumber;
    private  String  brand;

  @OneToOne
private Person1 person1;

    public Laptop1(int laptop_id, String modelNumber, String brand, Person1 person1) {
        this.laptop_id = laptop_id;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.person1 = person1;
    }

    public Laptop1() {
    }

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Person1 getPerson1() {
        return person1;
    }

    public void setPerson1(Person1 person1) {
        this.person1 = person1;
    }
}
