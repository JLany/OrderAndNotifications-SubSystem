package ordersmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderModel {
    private @Id @GeneratedValue Long id;
}
