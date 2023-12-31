package ordersmanagement.repositories;

import ordersmanagement.models.OrderModel;
import ordersmanagement.notifications.Notification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryNotificationRepository implements NotificationRepository {

    private final List<Notification> notifications = new ArrayList<>();

    @Override
    public List<Notification> findAll() {
        return notifications;
    }

    @Override
    public Notification save(Notification order) {
        notifications.add(order);

        return order;
    }

}
