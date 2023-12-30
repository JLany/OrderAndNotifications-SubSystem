package ordersmanagement;

import ordersmanagement.models.Address;
import ordersmanagement.models.Category;
import ordersmanagement.models.Customer;
import ordersmanagement.models.Product;
import ordersmanagement.repositories.CategoryRepository;
import ordersmanagement.repositories.CustomerRepository;
import ordersmanagement.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDatabase {

    private static final Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customers, ProductRepository products, CategoryRepository categories) {

        return args -> {
            customers.save(new Customer("Yousef", 1000.0, new Address()));

            categories.save(new Category(1L, "Toys"));
            categories.save(new Category(2L, "Food"));
            categories.save(new Category(3L, "Misc"));

            products.save(new Product("Choco", 10.0, "Galaxy", 2L, 10));
            products.save(new Product("Sandwich", 15.0, "Caco", 2L, 10));
            products.save(new Product("Biscuit", 11.0, "Loutsy", 2L, 10));
            products.save(new Product("Juice", 19.0, "Suntop", 2L, 10));
        };
    }

}
