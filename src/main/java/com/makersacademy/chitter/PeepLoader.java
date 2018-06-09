package com.makersacademy.chitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PeepLoader implements CommandLineRunner {

    private final PeepRepository peepRepository;

    @Autowired
    public PeepLoader(PeepRepository peepRepository) {
        this.peepRepository = peepRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.peepRepository.deleteAll();
        this.peepRepository.save(new Peep("Hey, folks! Welcome to Chitter!"));
    }
}
