package ordersmanagement.models.notifications;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class NotificationQueue {
    private ArrayList<Notification> _notificationsQueue;
    public boolean isEmpty(){
        return _notificationsQueue.isEmpty();
    }
    NotificationQueue(){
        _notificationsQueue = new ArrayList<>();
    }

    public void addToQueue(Notification notification){
        _notificationsQueue.add(notification);
    }

    public Notification dequeue(){
        if (_notificationsQueue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        return _notificationsQueue.remove(0);
    }

    public ArrayList<Notification> getQueueContents(){
        return _notificationsQueue;
    }

}
