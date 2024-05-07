package fr.fms.apitrainings.web;

import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.net.URI;

@CrossOrigin
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTraining() throws Exception {
        return implTrainingService.getTrainings();
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id") Long id){
        implTrainingService.deleteTraining(id);
    }


//    @PostMapping("/trainings")
//    public Training saveTraining(@RequestBody Training training){
//        return implTrainingService.saveTraining(training);
//    }

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
    public ResponseEntity<Training> getTrainingById(@PathVariable("id") Long id){
        Optional<Training> training = implTrainingService.readTraining(id);
        if(training.isPresent()){
            return new ResponseEntity<>(training.get(), HttpStatus.OK);
        }
        return null;
    }


}
