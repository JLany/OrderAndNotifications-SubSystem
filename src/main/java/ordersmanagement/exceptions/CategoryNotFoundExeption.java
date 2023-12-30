package ordersmanagement.exceptions;

import ordersmanagement.models.Category;

public class CategoryNotFoundExeption extends RuntimeException{
    public CategoryNotFoundExeption(){
        super("There is no such Category!");
    }
}
