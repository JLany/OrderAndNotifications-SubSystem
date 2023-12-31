package ordersmanagement.notifications;

import ordersmanagement.exceptions.NotSupportedNotificationChannelException;
import ordersmanagement.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSmsNotificationFacade extends NotificationFacade {

    @Autowired
    public EmailSmsNotificationFacade(NotificationDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected Notification createNotification(Customer customer, Message message) {
        return switch (customer.getPreferredChannel()) {
            case EMAIL -> new EmailNotification(customer.getEmail(), message);
            case SMS -> new SMSNotification(customer.getPhone(), message);
            default -> throw new NotSupportedNotificationChannelException("Not supported: " + customer.getPreferredChannel().toString());
        };
    }
}
