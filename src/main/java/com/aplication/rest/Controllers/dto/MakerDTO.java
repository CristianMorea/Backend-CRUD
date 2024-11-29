package com.aplication.rest.Controllers.dto;

import com.aplication.rest.Entities.Product;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class MakerDTO {
    private Long id;
    private String name;
    private List<Product> productList;

}
