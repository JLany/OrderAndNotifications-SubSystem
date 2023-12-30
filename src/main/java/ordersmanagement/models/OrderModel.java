package ordersmanagement.models;

import jakarta.persistence.CollectionTable;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {

    private Long id;
    private SimpleOrder order;
    private List<SimpleOrder> subOrders;

    public OrderModel() {
        order = new SimpleOrder();
        subOrders = new ArrayList<>();
    }

    public OrderModel(SimpleOrder order, List<SimpleOrder> subOrders, Long id) {
        this.id = id;
        this.order = order;
        this.subOrders = subOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleOrder getOrder() {
        return order;
    }

    public void setOrder(SimpleOrder order) {
        this.order = order;
    }

    public List<SimpleOrder> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SimpleOrder> subOrders) {
        this.subOrders = subOrders;
    }
}
