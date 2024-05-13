package fr.fms.apitrainings.dao;

import fr.fms.apitrainings.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
