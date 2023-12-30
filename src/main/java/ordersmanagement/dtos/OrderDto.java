package ordersmanagement.dtos;

import ordersmanagement.models.Address;

import java.util.List;

public class OrderDto {
    private Long customerId;
    private List<SimpleOrderDto> orders;

    public OrderDto() {
    }

    public OrderDto(Long customerId, List<SimpleOrderDto> orders) {
        this.customerId = customerId;
        this.orders = orders;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<SimpleOrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<SimpleOrderDto> orders) {
        this.orders = orders;
    }
}
