package ordersmanagement.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
    private @Id
    @GeneratedValue Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String email;
    private double balance;

    @Embedded
    private Address address;



    public Customer() {}
    public Customer(String name, String email,double balance, Address address) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.address = address;
    }



    public String getName() {
        return name;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
