package com.makersacademy.chitter;

import com.makersacademy.chitter.model.Peep;
import com.makersacademy.chitter.model.User;
import com.makersacademy.chitter.repository.PeepRepository;
import com.makersacademy.chitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PeepRepository peepRepository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(PeepRepository peepRepository, UserRepository userRepository) {
        this.peepRepository = peepRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        this.peepRepository.deleteAll();
        this.userRepository.deleteAll();
        User george = new User("george@email.com", "password", "password");
        Peep peep = new Peep("First peep");
        peep.setUser(george);
        this.peepRepository.save(new Peep("Hey, folks! Welcome to Chitter!"));
        this.userRepository.save(george);
    }
}
