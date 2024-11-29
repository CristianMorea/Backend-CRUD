package com.aplication.rest.Controllers;

import com.aplication.rest.Controllers.dto.ProductDTO;
import com.aplication.rest.Entities.Product;
import com.aplication.rest.Service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private Product product;


    //endpoint para retornar todos los productos
    @GetMapping("/finAll")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    //endpoint para retornar un producto dado un id

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        // Buscar el producto por ID usando el servicio
        Optional<Product> productOptional = productService.findtById(id);

        // Verificar si el producto existe
        if (productOptional.isPresent()) {
            Product product = productOptional.get(); // Extraer el producto del Optional

            // Crear un DTO para retornar
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();

            // Retornar el DTO en la respuesta
            return ResponseEntity.ok(productDTO);
        }

        // Retornar 404 si no se encuentra el producto
        return ResponseEntity.notFound().build();
    }





}
