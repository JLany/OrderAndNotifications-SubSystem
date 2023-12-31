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

    //TODO: (After the submission (Not required in the submission))
    //TODO:(Not required in the submission) add all CRUD operations
    //TODO: this comment should be removed before the submission

//    //adding new Category
//    @PostMapping("/addCategory")
//    public Category addCategory(@RequestBody Category category){
//        return categoryRepository.save(category);
//    }
//
//
//    //adding new Product
//    @PostMapping("/addProduct")
//    public Product addProduct(@RequestBody Product product){
//
//        //if the product is being added to a predefined Category
//        if(categoryRepository.existsById(product.getCategoryID())){
//            Category existingCategory = categoryRepository.findById(product.getCategoryID())
//                    .orElse(null);
//
//            //update the Remaining Quantity
//            existingCategory.addQuantity(product.getQuantity());
//            return productRepository.save(product);
//        }
//        else{
//            //else we will throw an exception
//            throw new CategoryNotFoundExeption();
//        }
//    }

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
