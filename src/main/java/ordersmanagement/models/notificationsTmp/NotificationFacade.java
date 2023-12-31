package ordersmanagement.models.notificationsTmp;

import ordersmanagement.models.notifications.Message;
import ordersmanagement.models.notifications.Notification;
import ordersmanagement.models.notificationsTmp.MessageFactory;
import ordersmanagement.models.notificationsTmp.NotificationFactory;

public class NotificationFacade {
    private final NotificationFactory notificationFactory;
    private final MessageFactory messageFactory;
    private Message message;
    private Notification notification;
    
    private Notification createNotification(){
        message = messageFactory.createMessage();
        notificationFactory.setMessage(message);
        return notificationFactory.createNotification();
    }

    public NotificationFacade(NotificationFactory notificationFactory, MessageFactory messageFactory) {
        this.notificationFactory = notificationFactory;
        this.messageFactory = messageFactory;
    }

    public void sendNotification(){
        Notification finalNotification = createNotification();

        //TODO: Send Message to queue logic

    }
}
