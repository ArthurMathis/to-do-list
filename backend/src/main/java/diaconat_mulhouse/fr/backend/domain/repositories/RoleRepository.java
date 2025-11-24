package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.Role.RoleJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleJPA, Long> {
}
