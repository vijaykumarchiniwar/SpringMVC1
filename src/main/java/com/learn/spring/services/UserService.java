package com.learn.spring.services;

import java.util.List;

import com.learn.spring.model.User;

public interface UserService {

    List<User> getAll();

    User findById(String id);

    User findByName(String name);

    void create(User user);

    void update(User user);

    void delete(String id);

    boolean exists(User user);
}