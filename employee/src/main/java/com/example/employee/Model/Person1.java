package com.example.employee.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person1 {
    @Id
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)

    private Laptop1 laptop1;

 @OneToMany
 private List<Address> addressList1;

    @OneToMany(mappedBy = "person1")
   private List<Address> addressList;

    public Person1() {
    }

    public Person1(int id, String name, List<Address> addressList1, List<Address> addressList) {
        this.id = id;
        this.name = name;
        this.addressList1 = addressList1;
        this.addressList = addressList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Address> getAddressList1() {
        return addressList1;
    }

    public void setAddressList1(List<Address> addressList1) {
        this.addressList1 = addressList1;
    }

    public String getName() {
        return name;
    }
//
    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

}
