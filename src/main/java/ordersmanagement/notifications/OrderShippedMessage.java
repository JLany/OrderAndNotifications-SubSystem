package ordersmanagement.notifications;


import jakarta.persistence.Embedded;
import ordersmanagement.models.Address;

// Dear {x}, please note that your product {y} is now out for delivery to {z};
public class OrderShippedMessage implements Message {
    private final String _template = "Dear %s, please note that your product %s is now out for delivery to %s";
    private final String _name;
    private final String _product;
    @Embedded
    private Address _address;

    public OrderShippedMessage(String name, String product, Address address){
        this._name = name;
        this._product = product;
        this._address = address;
    }

    public String getTemplate() {
        return _template;
    }

    @Override
    public String formulateMessage() {
        return String.format(_template,
                _name, _product, _address.toString());
    }
}
