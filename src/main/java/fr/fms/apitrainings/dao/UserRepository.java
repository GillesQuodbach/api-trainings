package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User findUserByUsername(String username);
}
