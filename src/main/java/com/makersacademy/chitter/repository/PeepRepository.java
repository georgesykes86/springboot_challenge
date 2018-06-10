package com.makersacademy.chitter.repository;

import com.makersacademy.chitter.model.Peep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeepRepository extends JpaRepository<Peep, Long> {
}
