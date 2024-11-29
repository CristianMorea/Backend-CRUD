package com.aplication.rest.repository;

import com.aplication.rest.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    //creando un metodo para productDAOImplement ya que necesito traer productos
    //en un rago especifico
    //  METODO POR QUERY

    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);



    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductByPriceInRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

}
