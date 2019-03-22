package com.dangkhoa.products.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "Product")
public class Products {

    @Id
    private ObjectId _id;

    private String name;

    private LocalDate created_at;

    private LocalDate expiration_time;

    private boolean status;

    private double price;

    public Products() {
    }

    public Products(ObjectId _id, String name, LocalDate created_at, LocalDate expiration_time, boolean status, double price) {
        this._id = _id;
        this.name = name;
        this.created_at = created_at;
        this.expiration_time = expiration_time;
        this.status = status;
        this.price = price;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(LocalDate expiration_time) {
        this.expiration_time = expiration_time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
