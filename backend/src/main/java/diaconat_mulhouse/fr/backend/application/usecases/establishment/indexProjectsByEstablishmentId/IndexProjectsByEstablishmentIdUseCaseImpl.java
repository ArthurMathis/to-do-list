package diaconat_mulhouse.fr.backend.application.usecases.establishment.indexProjectsByEstablishmentId;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.indexProjects.IndexProjectsByEstablishmentIdGateway;
import diaconat_mulhouse.fr.backend.presentation.DTOs.project.IndexProjectByEstablishmentIdDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

@AllArgsConstructor
public class IndexProjectsByEstablishmentIdUseCaseImpl implements IndexProjectsByEstablishmentIdUseCase {

    private final GetEstablishmentGateway getEstablishmentGateway;
    private final IndexProjectsByEstablishmentIdGateway indexProjectsByEstablishmentIdGateway;

    @Override
    public List<Project> execute(IndexProjectByEstablishmentIdDTO indexProjectByEstablishmentIdDTO) {
        Establishment currentEstablishment = this.getEstablishmentGateway.get(indexProjectByEstablishmentIdDTO.EstablishmentId());
        if(!currentEstablishment.getUsersId().contains(indexProjectByEstablishmentIdDTO.userId())) {
            throw new AccessDeniedException("The user : " + indexProjectByEstablishmentIdDTO.userId() + " doesn't work in establishment : " + indexProjectByEstablishmentIdDTO.EstablishmentId() + ".");
        }
        return this.indexProjectsByEstablishmentIdGateway.indexProject(indexProjectByEstablishmentIdDTO.EstablishmentId());
    }
}
