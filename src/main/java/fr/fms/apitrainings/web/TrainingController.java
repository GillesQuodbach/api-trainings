package fr.fms.apitrainings.web;

import fr.fms.apitrainings.dao.CategoryRepository;
import fr.fms.apitrainings.dao.UserRepository;
import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.entities.User;
import fr.fms.apitrainings.exceptions.RecordNotFoundException;
import fr.fms.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/trainings")
    public List<Training> allTraining() throws Exception {
        return implTrainingService.getTrainings();
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id") Long id){
        implTrainingService.deleteTraining(id);
    }


    @PostMapping("/trainings")
    public ResponseEntity<Training> saveTraining(@RequestBody Training t){
        Training training = implTrainingService.saveTraining(t);
                if(Objects.isNull(training)){
                    return ResponseEntity.noContent().build();
                }
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(training.getId())
                        .toUri();
                return ResponseEntity.created(location).build();
    }

    @GetMapping("/trainings/{id}")
    public Training getTrainingById(@PathVariable("id") Long id){
        return implTrainingService.readTraining(id)
                .orElseThrow(()-> new RecordNotFoundException("Id de Formation " + id + " n'existe pas"));
    }

    @GetMapping("/categories")
    public List<Category> allCategories() throws Exception {
        return implTrainingService.getAllCategories();
    }

    @GetMapping("/trainings/category/{id}")
    public List<Training> getTrainingByCategoryId(@PathVariable("id") Long id){
        return implTrainingService.getTrainingByCat(id);
    }

    // requête http://localhost:8080/api/users?username=anonymous
    // récupère l'utilisateur par username
    @GetMapping("/users")
    public User getUserByUsername(@RequestParam String username) throws Exception {
        return userRepository.findUserByUsername(username);
    }
}
