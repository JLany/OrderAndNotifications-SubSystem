package ordersmanagement.utility;

import ordersmanagement.config.GlobalConfiguration;
import ordersmanagement.dtos.OrderDto;
import ordersmanagement.models.OrderModel;
import ordersmanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderProcessor {

    private final OrderCreator orderCreator;
    private final OrderRepository orderRepository;
    private final BillingService billingService;

    @Autowired
    public OrderProcessor(OrderCreator orderCreator, OrderRepository orderRepository, BillingService billingService) {
        this.orderCreator = orderCreator;
        this.orderRepository = orderRepository;
        this.billingService = billingService;
    }

    public OrderModel createOrder(OrderDto orderDto) {
        OrderModel mainOrder = orderCreator.create(orderDto);

        orderRepository.save(mainOrder);

        return mainOrder;
    }

    // TODO - Implement this method ( confirmOrder )
    public void confirmOrder(OrderModel order) {
        // TODO - Notify the customer of order confirmation.
        // TODO - Deduct orders' amounts from each customer's balance.
    }

    // OrderShippedNotification
    // OrderConfirmedNotification
    // ...

    // TODO - Think through this.
//    public void notifyCustomer(NotificationStrategy notificationStrategy, OrderModel order) {
//
//    }


    public boolean canCancelOrder(OrderModel order) {
        if (order.getOrder().getCreatedDate()
                .isBefore(LocalDateTime.now()
                        .minusMinutes(GlobalConfiguration.CANCEL_ORDER_NUMBER_OF_MINUTES)
                )
        ) {
            return false;
        }

        return true;
    }

    public void cancelOrder(OrderModel order) {
        // TODO - Notify each customer that his corresponding order has been cancelled.
        // TODO - Credit customers' balances with each order's amount.

        orderRepository.deleteById(order.getId());
    }
}
