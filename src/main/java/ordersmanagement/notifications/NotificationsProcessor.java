package ordersmanagement.notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationsProcessor {
    private static final int NOTIFICATION_PROCESS_INTERVAL_SECONDS = 5;
    private NotificationDispatcher notificationDispatcher;

    @Autowired
    public NotificationsProcessor(NotificationDispatcher notificationDispatcher) {
        this.notificationDispatcher = notificationDispatcher;
    }

    @Scheduled(fixedDelay = NOTIFICATION_PROCESS_INTERVAL_SECONDS * 1000)
    public void processNotification(){
        notificationDispatcher.sendNextNotification();
    }
}
