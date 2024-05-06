package fr.fms.apitrainings.service;

import fr.fms.apitrainings.entities.Training;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface ITrainingService {
    public List<Training> getTrainings() throws Exception;

    public Training saveTraining(Training training) throws Exception;

    public void deleteTraining(Long id) throws Exception;

    public Training getTrainingById(Long id) throws Exception;

    public Optional<Training> readTraining(Long id);
}