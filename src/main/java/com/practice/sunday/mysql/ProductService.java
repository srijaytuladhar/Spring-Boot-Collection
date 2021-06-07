package com.practice.sunday.mysql;

import com.practice.sunday.exception.StudentExceptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String saveProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully!!";
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductsById(int id) {
        if  (productRepository.findById(id).isPresent()){
            return productRepository.findById(id).orElse(null);
        }
        else {
            throw new StudentExceptionRequest("Product not found");
        }

    }


    public String deleteProduct(int id) {
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return "Product deleted!!";
        }
        else {
            throw new StudentExceptionRequest("Cannot delete.... Product with id: " +id+ " does not exist");
        }

    }

    public String updateProduct(Product product) {
        if  (productRepository.findById(product.getId()).isPresent()) {
            Product existingProduct = productRepository.findById(product.getId()).orElse(null);
            existingProduct.setName(product.getName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setStocks(product.getStocks());
            productRepository.save(existingProduct);
            return "Product with id: " + product.getId() + " updated successfully!!";
        }
        else {
            throw new StudentExceptionRequest("Cannot updated the product.... Product with id: "
                    + product.getId() + " does not exist");
        }

    }
}
