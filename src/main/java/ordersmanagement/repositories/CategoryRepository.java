package ordersmanagement.repositories;

import ordersmanagement.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
