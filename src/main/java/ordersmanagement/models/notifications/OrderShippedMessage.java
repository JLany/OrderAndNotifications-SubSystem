package ordersmanagement.models.notifications;



// Dear {x}, please note that your product {y} is now out for delivery to {z};
public class OrderShippedMessage implements Message {
    private String _name;
    private String _product;
    private String _address;

    @Override
    public String formulateMessage() {
        return String.format("Dear %s, please note that your product %s is now out for delivery to %s",
                _name, _product, _address);

    }
}
