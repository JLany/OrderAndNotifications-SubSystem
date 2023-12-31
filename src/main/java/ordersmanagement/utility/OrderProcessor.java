package ordersmanagement.utility;

import ordersmanagement.config.GlobalConfiguration;
import ordersmanagement.dtos.OrderDto;
import ordersmanagement.models.OrderModel;
import ordersmanagement.repositories.OrderRepository;
import ordersmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderProcessor {

    private final OrderCreator orderCreator;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderProcessor(OrderCreator orderCreator, OrderRepository orderRepository) {
        this.orderCreator = orderCreator;
        this.orderRepository = orderRepository;
    }

    public OrderModel createOrderModel(OrderDto orderDto) {
        OrderModel mainOrder = orderCreator.create(orderDto);

        orderRepository.save(mainOrder);

        return mainOrder;
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
