package com.escuelita.demo.repository;

import com.escuelita.demo.entities.car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<car, Long> {
}
