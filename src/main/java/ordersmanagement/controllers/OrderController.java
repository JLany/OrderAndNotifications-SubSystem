package ordersmanagement.controllers;

import ordersmanagement.models.OrderModel;
import ordersmanagement.repositories.OrderRepository;
import ordersmanagement.utility.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrderController {

    private final OrderRepository repository;
    private final OrderProcessor processor;

    @Autowired
    public OrderController(OrderRepository repository, OrderProcessor processor) {
        this.repository = repository;
        this.processor = processor;
    }


    @GetMapping("api/orders")
    public List<OrderModel> getAll() {
        return repository.findAll();
    }

    @GetMapping("api/orders/{id}")
    public OrderModel get(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No order exists with id %d", id)));
    }

    // TODO - Implement method.
    public OrderModel add(@RequestBody List<OrderModel> orders, @RequestBody Long customerId) {
        // We need to find the order that has the customerId as it's customerId.
        // Then we add the rest of the orders to it as a list.

        // The for receiving a list of orders instead of a compound order is
        // to facilitate the operation of payload construction on the other end
        // of the network. And here we handle it and make sure it's processed and
        // stored as a compound order.

        // A class for order persistence might help encapsulate the above logic.

        return null;
    }

    // TODO - Implement method.
    @GetMapping("api/orders/cancel/{id}")
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
