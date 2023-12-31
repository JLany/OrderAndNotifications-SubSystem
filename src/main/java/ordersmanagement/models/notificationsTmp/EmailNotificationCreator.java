package ordersmanagement.models.notificationsTmp;

import ordersmanagement.models.notifications.EmailNotification;
import ordersmanagement.models.notifications.Message;
import ordersmanagement.models.notifications.Notification;

public class EmailNotificationCreator extends NotificationFactory{
    private String email;

    public EmailNotificationCreator(Message message, String email) {
        super(message);
        this.email = email;
    }


    @Override
    public Notification createNotification() {
        return new EmailNotification(email,message);
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Message getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }
}
