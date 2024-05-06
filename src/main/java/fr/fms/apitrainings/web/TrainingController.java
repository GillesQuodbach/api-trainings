package fr.fms.apitrainings.web;

import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTraining() throws Exception {
        return implTrainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public Training saveTraining(@RequestBody Training training){
        return implTrainingService.saveTraining(training);
    }
}
