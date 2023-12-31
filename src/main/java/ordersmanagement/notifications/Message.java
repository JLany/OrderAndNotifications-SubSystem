package ordersmanagement.notifications;

import jakarta.persistence.Embeddable;

@Embeddable
public interface Message {
    String formulateMessage();
    String getTemplate();
}
