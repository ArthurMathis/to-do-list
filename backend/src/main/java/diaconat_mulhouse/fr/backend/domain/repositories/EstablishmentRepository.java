package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<EstablishmentJPA, Long> {
}
