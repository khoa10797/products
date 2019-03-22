package com.dangkhoa.products.shedule;

import com.dangkhoa.products.repositotry.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CheckExpirationTime {

    @Autowired
    ProductRepository repository;

    @Scheduled(cron = "0 0 0 * * *")
    public void setInaciveStatus() {
        repository.updateByExpiration_time(LocalDate.now());
    }
}
