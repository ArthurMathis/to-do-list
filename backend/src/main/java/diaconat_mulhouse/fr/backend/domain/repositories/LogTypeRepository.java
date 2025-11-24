package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogTypeJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTypeRepository extends JpaRepository<LogTypeJPA, Long> {
}
