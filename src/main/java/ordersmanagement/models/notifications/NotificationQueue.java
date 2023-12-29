// TODO: is this in the right place??
package ordersmanagement.models.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NotificationQueue {
    private ArrayList<Notification> _notificationsQueue;
    NotificationQueue(){
        _notificationsQueue = new ArrayList<>();
    }

    public void addToQueue(Notification notification){
        _notificationsQueue.add(notification);
    }

    private Notification dequeue(){
        if (_notificationsQueue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        return _notificationsQueue.remove(0);
    }

    ArrayList<Notification> getQueueContents(){
        return _notificationsQueue;
    }

    // TODO: method to simulate removal from queue

}
