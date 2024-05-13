package fr.fms.apitrainings.service;

import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.entities.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface ITrainingService {
    List<Training> getTrainings() throws Exception;

    Training saveTraining(Training training) throws Exception;

    void deleteTraining(Long id) throws Exception;

    Training getTrainingById(Long id) throws Exception;

    Optional<Training> readTraining(Long id) throws Exception;

    List<Training> getTrainingByCat(Long id) throws Exception;

    List<Category> getAllCategories() throws Exception;

    List<User> getAllUsers() throws Exception;

    User getUser(String username) throws Exception;


}