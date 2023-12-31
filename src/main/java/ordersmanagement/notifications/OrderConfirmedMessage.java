package ordersmanagement.notifications;

// Dear {x} , your booking of the {y} is confirmed. thanks for using our store :)
public class OrderConfirmedMessage implements Message {
    private final String _template = "Dear %s , your booking of %d %s is confirmed. thanks for using our store :)";
    private String _name;
    private String _productName;
    private int _quantity;

    public OrderConfirmedMessage(String _name, String _productName, int quantity) {
        this._name = _name;
        this._productName = _productName;
        this._quantity = quantity;
    }

    public String getTemplate() {
        return _template;
    }

    @Override
    public String formulateMessage() {
        return String.format(_template,
                _name, _quantity, _productName);


    }
}
