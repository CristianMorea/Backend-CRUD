package com.aplication.rest.Entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;

}
