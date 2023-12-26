package ordersmanagement.repositories;

import ordersmanagement.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
