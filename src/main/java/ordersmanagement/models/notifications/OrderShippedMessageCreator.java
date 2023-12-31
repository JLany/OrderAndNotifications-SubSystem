package ordersmanagement.models.notifications;

public class OrderShippedMessageCreator implements MessageFactory{

    private String name;
    private String product;
    private String address;

    public OrderShippedMessageCreator(String name, String product, String address) {
        this.name = name;
        this.product = product;
        this.address = address;
    }

    @Override
    public Message createMessage() {
        return new OrderShippedMessage(name,product,address);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public String getAddress() {
        return address;
    }
}
