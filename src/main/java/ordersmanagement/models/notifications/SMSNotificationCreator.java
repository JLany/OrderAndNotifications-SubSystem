package ordersmanagement.models.notifications;

import java.util.PrimitiveIterator;

public class SMSNotificationCreator extends NotificationFactory{
    private String phoneNumber;

    public SMSNotificationCreator(Message message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Notification createNotification() {
        return new SMSNotification(phoneNumber,message);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
