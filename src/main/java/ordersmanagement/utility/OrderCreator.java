package ordersmanagement.utility;

import ordersmanagement.config.GlobalConfiguration;
import ordersmanagement.dtos.OrderDto;
import ordersmanagement.dtos.SimpleOrderDto;
import ordersmanagement.exceptions.OrderNotFoundException;
import ordersmanagement.models.OrderEntry;
import ordersmanagement.models.OrderModel;
import ordersmanagement.models.Product;
import ordersmanagement.models.SimpleOrder;
import ordersmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderCreator {

    private final ProductRepository productRepository;

    @Autowired
    public OrderCreator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public OrderModel create(OrderDto orderDto) {
        // We need to find the order that has the customerId as it's customerId.
        // Then we add the rest of the orders to it as a list.
        SimpleOrderDto mainDto = orderDto.getOrders().stream()
                .filter(dto -> dto.getCustomerId().equals(orderDto.getCustomerId()))
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException("Main order's customer id does not match the customer id provided in the request."));

        // Divide the shipping fees among all customers participating in this compound order.
        double shippingFees = GlobalConfiguration.SHIPPING_FEES / orderDto.getOrders().size();

        orderDto.getOrders().remove(mainDto);

        OrderModel mainOrder = new OrderModel();
        mainOrder.getOrder().setCustomerId(orderDto.getCustomerId());
        mainOrder.getOrder().setAddress(mainDto.getAddress());
        mainOrder.getOrder().setShipped(false);
        mainOrder.getOrder().setCreatedDate(LocalDateTime.now());
        mainOrder.getOrder().setShippingFees(shippingFees);

        mainOrder.getOrder().setEntries(
                mainDto.getEntries().stream()
                        .map(oed -> {
                            Product p = productRepository.findById(oed.getProductId()).orElseThrow();

                            return new OrderEntry(
                                    p,
                                    oed.getQuantity(),
                                    p.getPrice() * oed.getQuantity());
                        })
                        .toList()
        );

        mainOrder.getOrder().setTotal(
                mainOrder.getOrder().getEntries().stream()
                        .map(OrderEntry::getSubTotal)
                        .mapToDouble(Double::doubleValue)
                        .sum()
        );

        if (orderDto.getOrders().size() > 0) {
            for (SimpleOrderDto dto : orderDto.getOrders()) {
                SimpleOrder model = new SimpleOrder();

                model.setCustomerId(dto.getCustomerId());
                model.setAddress(dto.getAddress());
                model.setShipped(false);
                model.setCreatedDate(LocalDateTime.now());
                model.setShippingFees(shippingFees);

                model.setEntries(
                        dto.getEntries().stream()
                                .map(oed -> {
                                    Product p = productRepository.findById(oed.getProductId()).orElseThrow();

                                    return new OrderEntry(
                                            p,
                                            oed.getQuantity(),
                                            p.getPrice() * oed.getQuantity());
                                })
                                .toList()
                );

                model.setTotal(
                        model.getEntries().stream()
                                .map(OrderEntry::getSubTotal)
                                .mapToDouble(Double::doubleValue)
                                .sum()
                );

                mainOrder.getSubOrders().add(model);
            }
        }

        return mainOrder;
    }
}
