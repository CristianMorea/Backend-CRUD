package com.aplication.rest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fabricante")
//fabricante
public class Maker {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    //relation uno a muchos
    @OneToMany(mappedBy = "maker",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Product>productList = new ArrayList<>();

}
