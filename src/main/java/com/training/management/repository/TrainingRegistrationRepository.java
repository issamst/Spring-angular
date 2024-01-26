package com.training.management.repository;

import com.training.management.models.TrainingRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRegistrationRepository extends JpaRepository<TrainingRegistration, Long> {
}
