package ordersmanagement.models.notifications;

public class EmailNotification extends Notification {
    private String _email;

    public EmailNotification(String email, Message message) {
        super(message);
        _email = email;
    }
}
