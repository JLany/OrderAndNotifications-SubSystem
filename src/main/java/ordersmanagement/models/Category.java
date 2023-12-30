package ordersmanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Category {
    private @Id
    @GeneratedValue Long categoryID;
    private String name;
    private int remainingQuantity;

    public Category(@JsonProperty("name") String name){
//        this.categoryID = UUID.randomUUID();
        this.name = name;
        this.remainingQuantity = 0;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public void addQuantity(int quantity){
        this.remainingQuantity += quantity;
    }

    public boolean subtractQuantity(int quantity){
        if((this.remainingQuantity-quantity) < 0){
            return false;
        }

        this.remainingQuantity -= quantity;
        return true;
    }
}
