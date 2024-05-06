package fr.fms.apitrainings.service;

import fr.fms.apitrainings.entities.Training;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITrainingService {
    public List<Training> getTrainings() throws Exception;

    public Training saveTraining(Training training) throws Exception;

}