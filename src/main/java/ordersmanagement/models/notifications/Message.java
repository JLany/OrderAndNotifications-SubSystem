package ordersmanagement.models.notifications;

import jakarta.persistence.Embeddable;

@Embeddable
public interface Message {
    public String formulateMessage();
}
