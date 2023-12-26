package ordersmanagement.models.notifications;


// responsible for all statistics whether in-queue or out of queue
public abstract class NotificationDispatcher {
    NotificationQueue notificationQueue;

    // Add to queue
    public void dispatchNotification(Notification notification){
        notificationQueue.addToQueue(notification);


    }
}
