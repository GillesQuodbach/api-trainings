package fr.fms.apitrainings;

import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.service.ImplTrainingService;
import fr.fms.apitrainings.web.TrainingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(controllers = TrainingController.class)
public class TrainingControllerTest {
    @Autowired
    private MockMvc mockMvc; // sert a appeler la méthode perform

    @MockBean // ! obligatoire pour appeler le service
    private ImplTrainingService implTrainingService; // la méthode get("/api/trainings")
                                                    // va appeler : allTrainings()
    @MockBean
    private TrainingRepository trainingRepository;
    @Test
    public void testGetTrainings() throws Exception{
        mockMvc.perform(get("/api/trainings")).andExpect(status().isOk());
    }


}
