package ordersmanagement.controllers;

import ordersmanagement.models.OrderModel;
import ordersmanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/orders")
public class OrdersController {

    private final OrderRepository repository;

    @Autowired
    public OrdersController(OrderRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    List<OrderModel> getAll() {
        return repository.findAll();
    }

}
