package ordersmanagement.models.notifications;

public abstract class NotificationFactory {

    protected Message message;
    public NotificationFactory(Message message){
        this.message = message;
    }
    public abstract Notification createNotification();

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
