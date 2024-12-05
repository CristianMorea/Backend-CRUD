package com.aplication.rest.persistence.impl;


import com.aplication.rest.Entities.User;
import com.aplication.rest.persistence.IUserDAO;
import com.aplication.rest.repository.ProductRepository;
import com.aplication.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
       return null;
    }



    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
