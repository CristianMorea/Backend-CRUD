package com.aplication.rest.persistence;

import com.aplication.rest.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    List<User> findAll();
    Optional<User> findById(Long id);
    User findByEmail(String email);

    void save(User user);
    void update(User user);
    void delete(Long id);

}