package com.aplication.rest.persistence;

import com.aplication.rest.Entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    List<Product> findAll();

    Optional<Product> findtById(Long id);
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    void save(Product product);

    void DeleteById(Long id);

}
