package com.makersacademy.chitter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeepRepository extends JpaRepository<Peep, Long> {
}
