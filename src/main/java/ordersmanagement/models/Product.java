package ordersmanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {
    private final UUID serialNumber;
    private String name;
    private double price;
    private String vendor;
    private UUID categoryID;
    private int quantity;

    public Product(@JsonProperty("name") String name,@JsonProperty("price") double price,
                   @JsonProperty("vendor") String vendor,@JsonProperty("categoryID") UUID categoryID,
                   @JsonProperty("quantity") int quantity){

        serialNumber = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getVendor() {
        return vendor;
    }

    public UUID getCategoryID() {
        return categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setCategoryID(UUID categoryID) {
        this.categoryID = categoryID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
