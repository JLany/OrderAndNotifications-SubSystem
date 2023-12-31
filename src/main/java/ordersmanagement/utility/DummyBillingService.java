package ordersmanagement.utility;

import ordersmanagement.exceptions.CustomerNotFoundException;
import ordersmanagement.exceptions.NotEnoughBalanceException;
import ordersmanagement.models.Customer;
import ordersmanagement.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyBillingService implements BillingService {

    private final CustomerRepository customerRepository;

    @Autowired
    public DummyBillingService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void creditCustomer(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customer.setBalance(customer.getBalance() + amount);

        customerRepository.save(customer);
    }

    public void deductFromCustomer(Long customerId, double amount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        if (customer.getBalance() < amount) {
            throw new NotEnoughBalanceException(customerId);
        }

        customer.setBalance(customer.getBalance() - amount);

        customerRepository.save(customer);
    }
}
