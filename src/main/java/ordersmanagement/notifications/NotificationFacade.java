package ordersmanagement.notifications;

import ordersmanagement.models.Address;
import ordersmanagement.models.Customer;
import ordersmanagement.models.OrderEntry;
import ordersmanagement.models.OrderModel;

public abstract class NotificationFacade {

    private final NotificationDispatcher notificationDispatcher;

    protected NotificationFacade(NotificationDispatcher notificationDispatcher) {
        this.notificationDispatcher = notificationDispatcher;
    }

    public void notifyOrderConfirmed(Customer customer, OrderEntry entry) {
        Message message = new OrderConfirmedMessage(customer.getName(), entry.getProduct().getName(), entry.getQuantity());
        notifyCustomer(customer, message);
    }

    public void notifyOrderShipped(Customer customer, String productName, Address address) {
        Message message = new OrderShippedMessage(customer.getName(), productName, address);
        notifyCustomer(customer, message);
    }

    public void notifyOrderCancelled(Customer customer, OrderModel order) {
        Message message = new OrderCancelledMessage(customer.getName(), order.getId());
        notifyCustomer(customer, message);
    }

    private void notifyCustomer(Customer customer, Message message) {
        Notification notification = createNotification(customer, message);

        notificationDispatcher.dispatchNotification(notification);
    }

    protected abstract Notification createNotification(Customer customer, Message message);
}
