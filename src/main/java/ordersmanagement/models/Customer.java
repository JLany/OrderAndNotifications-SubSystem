package ordersmanagement.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Customer {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String balance;
    private Address address;

    public Customer(String name, String balance, Address address) {
        this.name = name;
        this.balance = balance;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
