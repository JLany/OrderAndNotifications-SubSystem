package ordersmanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Product {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private double price;
    private String vendor;
    private Long categoryID;
    private int quantity;

    public Product() {
    }

    public Product(@JsonProperty("name") String name,@JsonProperty("price") double price,
                   @JsonProperty("vendor") String vendor,@JsonProperty("categoryID") Long categoryID,
                   @JsonProperty("quantity") int quantity){
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCategoryID() {
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

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
