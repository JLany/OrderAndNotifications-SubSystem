package ordersmanagement.utility;

import ordersmanagement.config.GlobalConfiguration;
import ordersmanagement.dtos.OrderDto;
import ordersmanagement.models.OrderModel;
import ordersmanagement.models.SimpleOrder;
import ordersmanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderProcessor {

    private final OrderCreator orderCreator;
    private final OrderRepository orderRepository;
    private final OrderNotificationManager orderNotifications;
    private final OrderPaymentManager orderPayments;

    @Autowired
    public OrderProcessor(OrderCreator orderCreator, OrderRepository orderRepository,
                          OrderNotificationManager orderNotifications, OrderPaymentManager orderPayments) {
        this.orderCreator = orderCreator;
        this.orderRepository = orderRepository;
        this.orderPayments = orderPayments;
        this.orderNotifications = orderNotifications;
    }

    public OrderModel createOrder(OrderDto orderDto) {
        OrderModel mainOrder = orderCreator.create(orderDto);

        return mainOrder;
    }

    public void confirmOrder(OrderModel order) {
        orderNotifications.notifyOrderConfirmed(order);

        orderPayments.payOrder(order);

        orderRepository.save(order);
    }

    public void shipOrder(OrderModel order) {
        orderPayments.payOrderShippingFees(order);

        order.getOrder().setShipped(true);
        for (SimpleOrder o : order.getSubOrders()) {
            o.setShipped(true);
        }

        orderNotifications.notifyOrderShipped(order);
    }

    public boolean canCancelOrder(OrderModel order) {
        if (order.getOrder().getCreatedDate()
                .isBefore(LocalDateTime.now()
                        .minusMinutes(GlobalConfiguration.CANCEL_ORDER_NUMBER_OF_MINUTES)
                )
        ) {
            return false;
        }

        if (order.getOrder().isShipped()) {
            return false;
        }

        return true;
    }

    public void cancelOrder(OrderModel order) {
        orderNotifications.notifyOrderCancelled(order);

        orderPayments.refundOrder(order);

        orderRepository.deleteById(order.getId());
    }
}
