package ordersmanagement.controllers;

import ordersmanagement.dtos.OrderDto;
import ordersmanagement.exceptions.OrderNotFoundException;
import ordersmanagement.models.OrderModel;
import ordersmanagement.repositories.OrderRepository;
import ordersmanagement.utility.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository repository;
    private final OrderProcessor processor;

    @Autowired
    public OrderController(OrderRepository repository, OrderProcessor processor) {
        this.repository = repository;
        this.processor = processor;
    }


    @GetMapping("/orders")
    public List<OrderModel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/orders/{id}")
    public OrderModel get(@PathVariable Long id) {
        OrderModel order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Could not find order %d", id)));

        return order;
    }

    // TODO - Test add method (controller action).
    @PostMapping("/orders")
    public OrderModel add(@RequestBody OrderDto order) {
        // We need to find the order that has the customerId as it's customerId.
        // Then we add the rest of the orders to it as a list.
        OrderModel model = processor.createOrderModel(order);

        return repository.save(model);

        // The reason for receiving a list of orders instead of a compound order is
        // to facilitate the operation of payload construction on the other end
        // of the network. And here we handle it and make sure it's processed and
        // stored as a compound order.

        // A class for order persistence might help encapsulate the above logic.


    }

    // TODO - Implement method.
    @GetMapping("/orders/cancel/{id}")
    public boolean cancelOrder(@PathVariable Long orderId) {
        var cancellationCandidate = repository.findById(orderId);
        if (cancellationCandidate.isEmpty()) {

            // Do bad stuff.
        }

        boolean cancelSuccess = processor.cancelOrder(cancellationCandidate.get());

        if (cancelSuccess) {
//            processor.notifyCustomer();
        }

        // TODO - Try to make this action return something useful using HTTP. (400, 200, ..etc)
        return false;
    }
}
