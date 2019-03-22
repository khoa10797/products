package com.dangkhoa.products.repositotry;

import java.time.LocalDate;

public interface ProductRepositoryCustom {
    void updateByExpiration_time(LocalDate date);
}

