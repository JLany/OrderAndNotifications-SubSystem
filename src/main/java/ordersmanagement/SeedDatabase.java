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

            //Toys Category
            Category tempCategory = new Category("Toys");
            tempCategory.setRemainingQuantity(45);
            categories.save(tempCategory);
            Long tempCategoryID = tempCategory.getId();

            products.save(new Product("Teddy Bear", 60.0, "Toys R Us", tempCategoryID, 20));
            products.save(new Product("Car", 45.0, "Hot Wheels", tempCategoryID, 10));
            products.save(new Product("Pyramids Puzzle", 110.0, "LEGO", tempCategoryID, 15));

            //Tech Category
            tempCategory = new Category("Technology");
            tempCategory.setRemainingQuantity(60);
            categories.save(tempCategory);
            tempCategoryID = tempCategory.getId();

            products.save(new Product("Iphone 15", 60000.0, "Apple", tempCategoryID, 30));
            products.save(new Product("Samsung S23 Ultra", 45000.0, "Samsung", tempCategoryID, 20));
            products.save(new Product("Apple Watch", 11000.0, "Apple", tempCategoryID, 10));
        };
    }

}
