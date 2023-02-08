package com.aespinozamerida.madcowV2.service;


import com.aespinozamerida.madcowV2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /*
    *The java.util.Optional<T> class is a container class
    * introduced in Java 8 that can hold a value of a specific
    *  type or be empty. The main purpose of this class is
    *  to provide a way to represent and handle optional
    * values in a type-safe and null-safe way.
    * */
    public Optional<User> findByEmail(String email);
    public User createUser(User user);

    public User save(User user);

    public Optional<User> findById(Integer id);




    public List<User> getAllUsers();
}
