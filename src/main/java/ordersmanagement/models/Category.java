package ordersmanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Category {
    private final UUID categoryID;
    private String name;
    private int remainingQuantity;

    public Category(@JsonProperty("name") String name){
        this.categoryID = UUID.randomUUID();
        this.name = name;
        this.remainingQuantity = 0;
    }

    public UUID getCategoryID() {
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
}
