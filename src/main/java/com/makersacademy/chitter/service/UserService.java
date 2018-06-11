package com.makersacademy.chitter.service;

import com.makersacademy.chitter.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
