package diaconat_mulhouse.fr.backend.domain.repositories;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstablishmentRepository extends JpaRepository<EstablishmentJPA, Long> {
    List<EstablishmentJPA> id(Long id);
}
