package com.makersacademy.chitter;

import org.springframework.data.repository.CrudRepository;

public interface PeepRepository extends CrudRepository<Peep, Long> {
}
