package com.training.management.repository;

import com.training.management.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
