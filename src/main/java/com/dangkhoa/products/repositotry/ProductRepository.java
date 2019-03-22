package com.dangkhoa.products.repositotry;

import com.dangkhoa.products.model.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Products, ObjectId>, ProductRepositoryCustom {

    Products findByName(String name);

    List<Products> findAll();

    void deleteBy_id(ObjectId id);

    Products findBy_id(ObjectId id);
}
