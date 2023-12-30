package ordersmanagement.models.notifications;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public abstract class Notification {
    private @Id
    @GeneratedValue Long id;
    private Message _message;

    public Notification(Message message) {
        this._message = message;
    }

    public String getNotificationBody(){
        return _message.formulateMessage();
    }
}
