package ordersmanagement.exceptions;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException(Long customerId) {
        super(String.format("Customer %d does not have enough balance for the specified operation.", customerId));
    }
}
