package ordersmanagement.models.notifications;

public class SMSNotification extends Notification {
    private String _phoneNumber;

    public SMSNotification(String phoneNumber, Message message) {
        super(message);
        _phoneNumber = phoneNumber;
    }
}
