package ordersmanagement.utility;

import ordersmanagement.models.OrderModel;
import ordersmanagement.models.SimpleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPaymentManager {

    private final BillingService billingService;

    @Autowired
    public OrderPaymentManager(BillingService billingService) {
        this.billingService = billingService;
    }

    public void payOrder(OrderModel order) {
        // Deduct main order.
        billingService.deductFromCustomer(order.getOrder().getCustomerId(), order.getOrder().getTotal());

        // Deduct sub orders.
        for (SimpleOrder o : order.getSubOrders()) {
            billingService.deductFromCustomer(o.getCustomerId(), o.getTotal());
        }
    }

    public void payOrderShippingFees(OrderModel order) {
        billingService.deductFromCustomer(order.getOrder().getCustomerId(), order.getOrder().getShippingFees());

        for (SimpleOrder o : order.getSubOrders()) {
            billingService.deductFromCustomer(o.getCustomerId(), o.getShippingFees());
        }
    }

    public void refundOrder(OrderModel order) {
        billingService.creditCustomer(order.getOrder().getCustomerId(), order.getOrder().getTotal());

        for (SimpleOrder o : order.getSubOrders()) {
            billingService.creditCustomer(o.getCustomerId(), o.getTotal());
        }
    }
}
