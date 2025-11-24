package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.Project.ProjectJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectJPA, Long> {
}
