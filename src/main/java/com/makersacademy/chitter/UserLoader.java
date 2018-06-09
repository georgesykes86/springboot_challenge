package com.makersacademy.chitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.userRepository.deleteAll();
        this.userRepository.save(new User("user@email.com", "password"));
    }
}