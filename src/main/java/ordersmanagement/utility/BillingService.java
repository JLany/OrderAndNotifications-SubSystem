package ordersmanagement.utility;

import ordersmanagement.exceptions.CustomerNotFoundException;
import ordersmanagement.exceptions.NotEnoughBalanceException;
import ordersmanagement.models.Customer;

public interface BillingService {

    void creditCustomer(Long customerId, double amount);

    void deductFromCustomer(Long customerId, double amount);
}
