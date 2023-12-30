package ordersmanagement.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SimpleOrder {

    private Long customerId;
    private List<OrderEntry> entries;
    private double total;
    private Address address;
    private boolean isShipped;
    private LocalDateTime createdDate;

    public SimpleOrder() {
        this.entries = new ArrayList<>();
    }

    public SimpleOrder(List<OrderEntry> entries, double total, Address address, boolean isShipped, LocalDateTime createdDate, Long customerId) {
        this.entries = entries;
        this.total = total;
        this.address = address;
        this.isShipped = isShipped;
        this.createdDate = createdDate;
        this.customerId = customerId;
    }

    public List<OrderEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderEntry> entries) {
        this.entries = entries;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isShipped() {
        return isShipped;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
