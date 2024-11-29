package com.aplication.rest.Service.impl;

import com.aplication.rest.Entities.Product;
import com.aplication.rest.Service.IProductService;
import com.aplication.rest.persistence.IProductDAO;
import com.aplication.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Optional<Product> findtById(Long id) {
        return productDAO.findtById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {

        productDAO.save(product);
    }

    @Override
    public void DeleteById(Long id) {
        productDAO.DeleteById(id);

    }
}
