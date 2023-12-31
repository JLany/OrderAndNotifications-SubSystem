package ordersmanagement.models.notificationsTmp;

import ordersmanagement.models.notifications.Message;
import ordersmanagement.models.notifications.OrderConfirmedMessage;

public class OrderConfirmMessageCreator implements MessageFactory{
    private String name;
    private String productName;

    public OrderConfirmMessageCreator(String name, String productName){
        this.name = name;
        this.productName = productName;
    }

    @Override
    public Message createMessage() {
        return new OrderConfirmedMessage(name,productName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }
}
