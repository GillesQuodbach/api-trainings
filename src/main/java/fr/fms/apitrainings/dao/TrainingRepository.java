package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainingRepository extends JpaRepository<Training, Long> {
}
