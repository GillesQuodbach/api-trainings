package fr.fms.apitrainings.service;

import fr.fms.apitrainings.dao.CategoryRepository;
import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.dao.UserRepository;
import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService{

    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    private List<Training> trainingsList;

    @Override
    public List<Training> getTrainings() throws Exception {
        return trainingRepository.findAll();
    }

    @Override
    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
    }

    @Override
    public Training getTrainingById(Long id){
        return trainingRepository.findById(id).get();
    }

    @Override
    public Optional<Training> readTraining(Long id){
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> getTrainingByCat(Long id){ return trainingRepository.findByCategoryId(id);}

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public User getUser(String username){
        return userRepository.findUserByUsername(username);
    }
}
