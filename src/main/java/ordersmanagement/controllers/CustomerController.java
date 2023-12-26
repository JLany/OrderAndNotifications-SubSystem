package ordersmanagement.controllers;

import ordersmanagement.exceptions.CustomerNotFoundException;
import ordersmanagement.models.Customer;
import ordersmanagement.repositories.CustomerRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/customers")
    Customer addCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    Customer getCustomer(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return repository.findAll();
    }

}
