package ordersmanagement.notifications;

public class OrderCancelledMessage implements Message {

    private final String _template = "Dear %s, please note that your order %d was cancelled.";
    private final String _name;
    private final Long _orderId;

    public OrderCancelledMessage(String _name, Long orderId) {
        this._name = _name;
        _orderId = orderId;
    }

    public String getTemplate() {
        return _template;
    }

    @Override
    public String formulateMessage() {
        return String.format(_template,
                _name, _orderId);
    }
}
