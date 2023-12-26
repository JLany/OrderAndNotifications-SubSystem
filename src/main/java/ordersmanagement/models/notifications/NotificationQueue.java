// TODO: is this in the right place??
package ordersmanagement.models.notifications;
import java.util.ArrayList;
import java.util.List;

public class NotificationQueue {
    List<Notification> _notificationsQueue;
    NotificationQueue(){
        _notificationsQueue = new ArrayList<>();
    }

    public void addToQueue(Notification notification){
        _notificationsQueue.add(notification);
    }

    // TODO: method to simulate removal from queue

}
