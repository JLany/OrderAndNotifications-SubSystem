package ordersmanagement.models.notifications;

// Dear {x} , your booking of the {y} is confirmed. thanks for using our store :)
public class OrderConfirmedMessage implements Message {
    private String _name;
    private String _productName;

    public OrderConfirmedMessage(String _name, String _productName) {
        this._name = _name;
        this._productName = _productName;
    }

    @Override
    public String formulateMessage() {
        return String.format("Dear %s , your booking of the %s is confirmed. thanks for using our store :)",
                _name, _productName);


    }
}
