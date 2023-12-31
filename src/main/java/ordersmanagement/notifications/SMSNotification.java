package ordersmanagement.notifications;

public class SMSNotification extends Notification {
    private String _phoneNumber;

    public SMSNotification(String phoneNumber, Message message) {
        super(message);
        _phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return _phoneNumber;
    }
}
