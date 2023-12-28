package ordersmanagement.utility;

import ordersmanagement.models.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProcessor {

    public OrderModel createOrderModel(List<OrderModel> orders, Long customerId) {
        return null;
    }

    // OrderShippedNotification
    // OrderConfirmedNotification
    // ...
    public void notifyCustomer(NotificationStrategy notificationStrategy, OrderModel order) {

    }

    // Might need a strategy factory as well.

    public boolean cancelOrder(OrderModel order) {
        // Return true, if canceled successfully.
        // Return false otherwise.

        return false;
    }
}
