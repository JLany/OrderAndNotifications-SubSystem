package ordersmanagement.controllers;

import ordersmanagement.dtos.OrderDto;
import ordersmanagement.exceptions.OrderCannotBeCancelledException;
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

    @GetMapping("/orders/{orderId}")
    public OrderModel get(@PathVariable Long orderId) {
        OrderModel order = repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Could not find order %d", orderId)));

        return order;
    }

    @PostMapping("/orders")
    public OrderModel add(@RequestBody OrderDto order) {
        OrderModel model = processor.createOrderModel(order);

        // TODO - Notify the customer of order confirmation.

        // TODO - Deduct orders' amounts from each customer's balance.

        return model;
    }

    @GetMapping("/orders/ship/{orderId}")
    public void shipOrder(@PathVariable Long orderId) {
        OrderModel shippingCandidate = repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Could not find order %d", orderId)));

        // TODO - Notify customers of order shipment.

        // TODO - Deduct shipping fees of each order from it's corresponding customer.
    }

    @GetMapping("/orders/cancel/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        OrderModel cancellationCandidate = repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Could not find order %d", orderId)));

        if (!processor.canCancelOrder(cancellationCandidate)) {
            throw new OrderCannotBeCancelledException(
                    String.format("Order %d cannot be cancelled. Cancellation duration limit exceeded.", orderId));
        }

        // TODO - Notify each customer that his corresponding order has been cancelled.
        // TODO - Credit customers' balances with each order's amount.

        processor.cancelOrder(cancellationCandidate);
    }
}
