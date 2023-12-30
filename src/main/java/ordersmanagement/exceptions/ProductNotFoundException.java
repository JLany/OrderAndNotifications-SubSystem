package ordersmanagement.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){
        super("There is no such Product!");
    }
}
