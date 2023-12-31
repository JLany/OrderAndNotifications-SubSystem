package ordersmanagement.notifications;

public class OrderConfirmedMessageAR implements Message{
    private final String _template = "اهلا وسهلا %s برجاء العلم انه تم تاكيد طلبكم ل %s";
    private final String _name;
    private final String _productName;

    public OrderConfirmedMessageAR(String _name, String _productName) {
        this._name = _name;
        this._productName = _productName;
    }

    public String getTemplate() {
        return _template;
    }

    @Override
    public String formulateMessage() {
        return String.format(_template,
                _productName, _name);
    }
}
