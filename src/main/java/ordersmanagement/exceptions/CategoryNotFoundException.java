package ordersmanagement.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(){
        super("There is no such Category!");
    }
}
