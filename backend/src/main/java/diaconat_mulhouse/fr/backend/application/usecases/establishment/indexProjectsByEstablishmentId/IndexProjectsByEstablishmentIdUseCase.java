package diaconat_mulhouse.fr.backend.application.usecases.establishment.indexProjectsByEstablishmentId;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import diaconat_mulhouse.fr.backend.presentation.DTOs.project.IndexProjectByEstablishmentIdDTO;

import java.util.List;

public interface IndexProjectsByEstablishmentIdUseCase extends UseCase<IndexProjectByEstablishmentIdDTO, List<Project>> {
}
