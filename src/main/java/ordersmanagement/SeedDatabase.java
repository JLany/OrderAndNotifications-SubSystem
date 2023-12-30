package ordersmanagement;

import ordersmanagement.models.Address;
import ordersmanagement.models.Customer;
import ordersmanagement.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDatabase {

    private static final Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customers, ProductRepository products) {

        return args -> {
            customers.save(new Customer("Yousef", 1000.0, new Address()));

            products.save(new ProductModel(1L, 100.0, 14));
            products.save(new ProductModel(2L, 100.0, 14));
            products.save(new ProductModel(3L, 50.49, 14));
            products.save(new ProductModel(4L, 100.0, 14));
        };
    }

}
