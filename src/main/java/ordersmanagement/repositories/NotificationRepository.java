package ordersmanagement.repositories;
import ordersmanagement.models.OrderModel;
import ordersmanagement.notifications.Notification;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface NotificationRepository {
    List<Notification> findAll();
    Notification save(Notification notification);
}
