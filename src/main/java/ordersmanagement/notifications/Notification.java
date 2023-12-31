package ordersmanagement.notifications;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public abstract class Notification {
    private @Id
    @GeneratedValue Long id;

    @Embedded
    private Message _message;

    public Notification(Message message) {
        this._message = message;
    }

    public String getNotificationBody(){
        return _message.formulateMessage();
    }

    public String getTemplate() { return _message.getTemplate(); }
}
