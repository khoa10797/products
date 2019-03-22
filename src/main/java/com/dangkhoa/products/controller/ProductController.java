package com.dangkhoa.products.controller;

import com.dangkhoa.products.model.Products;
import com.dangkhoa.products.repositotry.ProductRepository;
import com.dangkhoa.products.repositotry.ProductRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @GetMapping(path = "products/", produces = "application/json")
    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping(path = "product/{name}")
    public Products getProductByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @PostMapping(path = "add-product/")
    public Products createProduct(@Valid @RequestBody Products products) {
        products.set_id(ObjectId.get());
        products.setStatus(true);
        products.setCreated_at(LocalDate.now());
        repository.save(products);
        return products;
    }

    @PutMapping(path = "modify/{id}/{price}")
    public void modifyProductById(@PathVariable("id") ObjectId id, @PathVariable("price") double price) {
        Products products = repository.findBy_id(id);
        products.setPrice(price);
        repository.save(products);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteProduct(@PathVariable("id") ObjectId id) {
        repository.deleteBy_id(id);
    }
}
