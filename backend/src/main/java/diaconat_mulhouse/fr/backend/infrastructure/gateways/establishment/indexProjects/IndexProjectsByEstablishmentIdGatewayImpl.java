package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.indexProjects;

import diaconat_mulhouse.fr.backend.application.converters.project.jpa.ProjectJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IndexProjectsByEstablishmentIdGatewayImpl implements IndexProjectsByEstablishmentIdGateway {

    private final EstablishmentRepository establishmentRepository;
    private final ProjectJPAConverter projectJPAConverter;

    @Override
    public List<Project> indexProject(long establishmentId) {
        EstablishmentJPA fetchedEstablishment = this.establishmentRepository.findById(establishmentId).orElseThrow(() -> {
            return new EntityNotFoundException("Establishment with id " + establishmentId + " not found");
        });
        return fetchedEstablishment.getProjects().stream().map(this.projectJPAConverter::toDto).toList();
    }
}
