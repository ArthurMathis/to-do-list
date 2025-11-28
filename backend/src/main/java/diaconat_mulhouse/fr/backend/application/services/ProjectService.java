package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.application.converters.project.json.ProjectJsonConverter;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.indexProjectsByEstablishmentId.IndexProjectsByEstablishmentIdUseCase;
import diaconat_mulhouse.fr.backend.presentation.DTOs.project.IndexProjectByEstablishmentIdDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.project.ProjectJsonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final IndexProjectsByEstablishmentIdUseCase indexProjectsByEstablishmentIdUseCase;

    private final ProjectJsonConverter projectJsonConverter;

    public List<ProjectJsonDTO> indexProjectsByEstablishmentId(long userId, long establishmentId) {
        return indexProjectsByEstablishmentIdUseCase.execute(new IndexProjectByEstablishmentIdDTO(userId, establishmentId)).stream()
                .map(this.projectJsonConverter::toDto).toList();
    }

}
