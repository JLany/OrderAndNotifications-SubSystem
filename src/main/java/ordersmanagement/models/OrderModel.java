package ordersmanagement.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderModel {

    private @Id @GeneratedValue Long id;
    private List<OrderModel> subOrders;
    private List<OrderEntryModel> entries;
    private double total;
    private Address address;
    private boolean isShipped;
    private LocalDateTime createdDate;

    public OrderModel() {
    }

    public OrderModel(List<OrderModel> subOrders, List<OrderEntryModel> entries, double total, Address address, boolean isShipped, LocalDateTime createdDate) {
        this.subOrders = subOrders;
        this.entries = entries;
        this.total = total;
        this.address = address;
        this.isShipped = isShipped;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderModel> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<OrderModel> subOrders) {
        this.subOrders = subOrders;
    }

    public List<OrderEntryModel> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderEntryModel> entries) {
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
}
