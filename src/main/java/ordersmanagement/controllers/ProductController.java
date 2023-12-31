package ordersmanagement.controllers;

import ordersmanagement.exceptions.CategoryNotFoundException;
import ordersmanagement.exceptions.ProductNotFoundException;
import ordersmanagement.models.Category;
import ordersmanagement.models.Product;
import ordersmanagement.repositories.CategoryRepository;
import ordersmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //get all Categories
    @GetMapping("/allCategories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //get all Products
    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //get Category By ID
    @GetMapping("/getCategory/{id}")
    public Category getCategoryByID(@PathVariable Long id){
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    //get Product by ID
    @GetMapping("/getProduct/{id}")
    public Product getProductByID(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
