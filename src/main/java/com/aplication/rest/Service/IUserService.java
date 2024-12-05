package com.aplication.rest.Service;

import com.aplication.rest.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    User findByEmail(String email);
    User findByUsername(String username);
    void save(User user);
    void update(User user);
    void delete(Long id);

}
