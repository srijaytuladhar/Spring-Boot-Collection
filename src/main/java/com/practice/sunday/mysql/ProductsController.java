package com.practice.sunday.mysql;

import com.practice.sunday.paths.PathHandler;
import com.practice.sunday.response.CrudResponse;
import com.practice.sunday.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;
    private ProductResponse productResponse;
    private PathHandler pathHandler;

    @GetMapping(PathHandler.products_path)
    public ProductResponse findProducts() {
        return new ProductResponse(productService.getProducts(), "Displaying product details....", HttpStatus.OK);
    }

    @GetMapping(PathHandler.products_by_id)
    public Product findProductById(@PathVariable int id) {
        return productService.getProductsById(id);
    }

    @PostMapping(PathHandler.products_path)
    public CrudResponse addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new CrudResponse("Product added successfully!!",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }

    @PostMapping(PathHandler.products_multiple)
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }


    @PutMapping(PathHandler.products_path)
    public CrudResponse updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new CrudResponse("Product with id: " + product.getId() + " updated successfully!!",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }

    @DeleteMapping(PathHandler.products_by_id)
    public CrudResponse deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new CrudResponse("Product with id: " + id + " deleted successfully!!",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }
}
