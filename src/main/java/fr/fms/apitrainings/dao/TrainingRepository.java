package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAll();

    List<Training> findByCategoryId(Long id);

}
