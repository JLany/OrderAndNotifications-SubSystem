package ordersmanagement.repositories;

import ordersmanagement.models.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryOrderRepository implements OrderRepository {
    private static Long NextId = 1L;
    private final List<OrderModel> orders = new ArrayList<>();

    @Override
    public Optional<OrderModel> findById(Long id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    @Override
    public List<OrderModel> findAll() {
        return orders;
    }

    @Override
    public OrderModel save(OrderModel order) {
        order.setId(NextId);
        ++NextId;
        orders.add(order);

        return order;
    }

    @Override
    public void deleteById(Long id) {
        Optional<OrderModel> deleteCandidate = findById(id);

        deleteCandidate.ifPresent(orders::remove);
    }
}
