package ordersmanagement.repositories;
import ordersmanagement.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface customerRepository extends JpaRepository<Customer, Long> {
}
