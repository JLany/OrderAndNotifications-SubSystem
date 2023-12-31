package ordersmanagement.controllers;

import ordersmanagement.exceptions.CustomerNotFoundException;
import ordersmanagement.models.Customer;
import ordersmanagement.repositories.CustomerRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/api/customers")
    Customer addCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/api/customers/{id}")
    Customer getCustomer(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @GetMapping("/api/customers")
    List<Customer> getAllCustomers() {
        return repository.findAll();
    }
    @PutMapping("/api/customers/{id}")
    Customer editCustomer(@RequestBody Customer customer,@PathVariable Long id)
    {
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setBalance(customer.getBalance());
        existingCustomer.setAddress(customer.getAddress());
        return repository.save(existingCustomer);
    }
    @DeleteMapping("/api/customers/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @DeleteMapping("/api/customers")
    void deleteAllEmployee() {
        repository.deleteAll();
    }


}
