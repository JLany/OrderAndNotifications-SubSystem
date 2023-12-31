package ordersmanagement.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import ordersmanagement.notifications.NotificationChannel;

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
    private String phone;
    private NotificationChannel preferredChannel;



    public Customer() {}

    public Customer(String name, double balance, Address address, String email, String phone, NotificationChannel preferredChannel) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.preferredChannel = preferredChannel;
    }



    public String getName() {
        return name;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NotificationChannel getPreferredChannel() {
        return preferredChannel;
    }

    public void setPreferredChannel(NotificationChannel preferredChannel) {
        this.preferredChannel = preferredChannel;
    }
}
