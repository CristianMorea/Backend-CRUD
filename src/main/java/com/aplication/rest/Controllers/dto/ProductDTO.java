package com.aplication.rest.Controllers.dto;

import com.aplication.rest.Entities.Maker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price; //es similar al float

}
