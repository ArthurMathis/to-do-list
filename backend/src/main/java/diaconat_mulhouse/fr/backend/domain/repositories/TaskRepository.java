package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.Task.TaskJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskJPA, Long> {
}
