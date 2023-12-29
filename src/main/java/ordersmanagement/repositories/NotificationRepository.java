package ordersmanagement.repositories;
import ordersmanagement.models.notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
