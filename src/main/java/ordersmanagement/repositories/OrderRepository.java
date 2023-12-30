package ordersmanagement.repositories;

import ordersmanagement.models.OrderModel;
import ordersmanagement.models.SimpleOrder;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  {
    Optional<OrderModel> findById(Long id);
    List<OrderModel> findAll();
    OrderModel save(OrderModel order);
    void deleteById(Long id);
}
