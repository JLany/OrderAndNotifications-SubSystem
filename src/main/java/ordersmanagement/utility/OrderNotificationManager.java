package ordersmanagement.utility;

import ordersmanagement.models.Customer;
import ordersmanagement.models.OrderEntry;
import ordersmanagement.models.OrderModel;
import ordersmanagement.models.SimpleOrder;
import ordersmanagement.notifications.NotificationFacade;
import ordersmanagement.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationManager {

    private final NotificationFacade notifications;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderNotificationManager(NotificationFacade notifications, CustomerRepository customerRepository) {
        this.notifications = notifications;
        this.customerRepository = customerRepository;
    }

    public void notifyOrderConfirmed(OrderModel order) {
        // Notify main order.
        Customer customer = customerRepository.findById(order.getOrder().getCustomerId()).get();

        for (OrderEntry oe : order.getOrder().getEntries()) {
            notifications.notifyOrderConfirmed(customer, oe);
        }

        for (SimpleOrder o : order.getSubOrders()) {
            customer = customerRepository.findById(o.getCustomerId()).get();

            for (OrderEntry oe : o.getEntries()) {
                notifications.notifyOrderConfirmed(customer, oe);
            }
        }
    }

    public void notifyOrderShipped(OrderModel order) {
        Customer customer = customerRepository.findById(order.getOrder().getCustomerId()).get();

        for (OrderEntry oe : order.getOrder().getEntries()) {
            notifications.notifyOrderShipped(customer, oe.getProduct().getName(), order.getOrder().getAddress());
        }

        for (SimpleOrder o : order.getSubOrders()) {
            customer = customerRepository.findById(o.getCustomerId()).get();

            for (OrderEntry oe : o.getEntries()) {
                notifications.notifyOrderShipped(customer, oe.getProduct().getName(), o.getAddress());
            }
        }
    }

    public void notifyOrderCancelled(OrderModel order) {
        Customer customer = customerRepository.findById(order.getOrder().getCustomerId()).get();

        notifications.notifyOrderCancelled(customer, order);
    }
}
