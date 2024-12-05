package com.aplication.rest.Controllers;

import com.aplication.rest.Entities.User;
import com.aplication.rest.Service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios.");
    }

    @GetMapping("user/name")
    public ResponseEntity<?> getUserByName(@RequestParam String name) {
        User user = userService.findByUsername(name);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @PostMapping("userUpdate")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }






}
