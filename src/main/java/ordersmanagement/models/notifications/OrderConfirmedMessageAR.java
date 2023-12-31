package ordersmanagement.models.notifications;

public class OrderConfirmedMessageAR implements Message{
    private final String _name;
    private final String _productName;

    public OrderConfirmedMessageAR(String _name, String _productName) {
        this._name = _name;
        this._productName = _productName;
    }

    @Override
    public String formulateMessage() {
        return String.format("اهلا وسهلا %s برجاء العلم انه تم تاكيد طلبكم ل %s",
                _productName, _name);
    }
}
