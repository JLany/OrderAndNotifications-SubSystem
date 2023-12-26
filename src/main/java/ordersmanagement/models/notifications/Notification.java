package ordersmanagement.models.notifications;

public abstract class Notification {
    private Message _message;

    public Notification(Message message) {
        this._message = message;
    }

    public String getNotificationBody(){
        return _message.formulateMessage();
    }
}
