package ordersmanagement.models.notifications;


import jakarta.persistence.Embedded;
import ordersmanagement.models.Address;

// Dear {x}, please note that your product {y} is now out for delivery to {z};
public class OrderShippedMessage implements Message {
    private String _name;
    private String _product;
    @Embedded
    private Address _address;

    public OrderShippedMessage(String name, String product, Address address){
        this._name = name;
        this._product = product;
        this._address = address;
    }

    public OrderShippedMessage(String _name,String _product,String _address){
        this._name = _name;
        this._product = _product;
        this._address = _address;
    }

    @Override
    public String formulateMessage() {
        return String.format("Dear %s, please note that your product %s is now out for delivery to %s",
                _name, _product, _address.toString());
    }

}
