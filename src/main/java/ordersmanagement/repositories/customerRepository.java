package ordersmanagement.repositories;
import ordersmanagement.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface customerRepository extends JpaRepository<Customer, Long> {

}
