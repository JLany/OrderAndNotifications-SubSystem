package ordersmanagement.controllers;

import ordersmanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/orders")
public class OrdersController {

    private final OrderRepository repository;

    @Autowired
    public OrdersController(OrderRepository repository) {
        this.repository = repository;
    }
}
