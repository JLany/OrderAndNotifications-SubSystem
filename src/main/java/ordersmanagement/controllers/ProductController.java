package ordersmanagement.controllers;

import ordersmanagement.exceptions.CategoryNotFoundExeption;
import ordersmanagement.models.Category;
import ordersmanagement.models.Product;
import ordersmanagement.repositories.CategoryRepository;
import ordersmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/Product")
@RestController
public class ProductController {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //adding new Category
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }


    //adding new Product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){

        //if the product is being added to a predefined Category
        if(categoryRepository.existsById(product.getCategoryID())){
            Category existingCategory = categoryRepository.findById(product.getCategoryID())
                    .orElse(null);

            //update the Remaining Quantity
            existingCategory.addQuantity(product.getQuantity());
            return productRepository.save(product);
        }
        else{
            //else we will throw an exception
            throw new CategoryNotFoundExeption();
        }
    }

    //get all Categories
    @GetMapping("getCategories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //get all Products
    @GetMapping("getProducts")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }



}
