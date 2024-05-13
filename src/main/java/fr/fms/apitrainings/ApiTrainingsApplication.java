package fr.fms.apitrainings;

import fr.fms.apitrainings.dao.CategoryRepository;
import fr.fms.apitrainings.dao.RoleRepository;
import fr.fms.apitrainings.dao.TrainingRepository;
import fr.fms.apitrainings.dao.UserRepository;
import fr.fms.apitrainings.entities.Category;
import fr.fms.apitrainings.entities.Role;
import fr.fms.apitrainings.entities.Training;
import fr.fms.apitrainings.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Categories list
		Category frontEnd = categoryRepository.save(new Category(null, "Front", "formation front end", null));
		Category backEnd = categoryRepository.save(new Category(null, "Back", "formation back end", null));
		Category web = categoryRepository.save(new Category(null, "Web", "formation Web", null));
		Category ia = categoryRepository.save(new Category(null, "IA", "formation IA", null));
		// Trainings list
		trainingRepository.save(new Training(null, "Java", "Java Standard Edition 8 sur 5 jours",3500,1,frontEnd));
		trainingRepository.save(new Training(null, "Java", "Java Standard Edition 8 sur 5 jours",3500,1,frontEnd));
		trainingRepository.save(new Training(null, "Java", "Java Standard Edition 8 sur 5 jours",3500,1,frontEnd));
		trainingRepository.save(new Training(null, "Java", "Java Standard Edition 8 sur 5 jours",3500,1,frontEnd));
		trainingRepository.save(new Training(null, "DotNet", "DotNet & entityframework en 5 jours",2750,1, backEnd));
		trainingRepository.save(new Training(null, "DotNet", "DotNet & entityframework en 5 jours",2750,1, backEnd));
		trainingRepository.save(new Training(null, "DotNet", "DotNet & entityframework en 5 jours",2750,1, backEnd));
		trainingRepository.save(new Training(null, "DotNet", "DotNet & entityframework en 5 jours",2750,1, backEnd));
		trainingRepository.save(new Training(null, "PowerBi", "Business Intelligence 5 jours",3000,1, web));
		trainingRepository.save(new Training(null, "PowerBi", "Business Intelligence 5 jours",3000,1, web));
		trainingRepository.save(new Training(null, "PowerBi", "Business Intelligence 5 jours",3000,1, web));
		trainingRepository.save(new Training(null, "NodeJs", "Prise en main de NodeJs/Express 2 jours",1400,1, web));
		trainingRepository.save(new Training(null, "Php", "Initiation au Dev/Web avec Php 4 jours",1300,1, ia));
		trainingRepository.save(new Training(null, "Php", "Initiation au Dev/Web avec Php 4 jours",1300,1, ia));
		trainingRepository.save(new Training(null, "Php", "Initiation au Dev/Web avec Php 4 jours",1300,1, ia));
		trainingRepository.save(new Training(null, "Php", "Initiation au Dev/Web avec Php 4 jours",1300,1, ia));

		generateData();
	}

	public void generateData(){
		Role userRole = roleRepository.save(new Role("user", null));
		Role adminRole = roleRepository.save(new Role("admin", null));
		// réation du role user
		userFactory( "gilles","1234", true, userRole);
		userFactory( "anonymous","Cefasim@_576486", true, adminRole);
	}

	private void userFactory(String username, String password, boolean active, Role... roles){

		List<Role> usersRoles = Arrays.asList(roles);
		String encodedPassword = passwordEncoder.encode(password);
		userRepository.save(new User(username, encodedPassword, true, usersRoles));
	}

}
