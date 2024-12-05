package com.aplication.rest.Controllers;

import com.aplication.rest.Entities.User;
import com.aplication.rest.Service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    private User user;


    @GetMapping("/users")
    public ResponseEntity<?> getUser() {
        // Obtener la lista de usuarios
        List<User> users = userService.findAll();

        // Verificar si la lista está vacía
        if (users.isEmpty()) {
            // Devuelve un estado 404 (No encontrado) con un mensaje adecuado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios.");
        }

        // Si la lista no está vacía, devuelve la lista completa de usuarios
        return ResponseEntity.ok(users);
    }





}
