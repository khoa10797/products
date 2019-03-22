package com.dangkhoa.products.repositotry;

import com.dangkhoa.products.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDate;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateByExpiration_time(LocalDate date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("expiration_time").is(date));
        Update update = new Update();
        update.set("status", false);
        mongoTemplate.updateMulti(query, update, Products.class);
    }
}
