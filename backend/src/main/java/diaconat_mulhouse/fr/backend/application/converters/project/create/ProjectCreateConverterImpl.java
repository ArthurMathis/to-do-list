package diaconat_mulhouse.fr.backend.application.converters.project.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.CreateProjectDTO;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreateConverterImpl implements ProjectCreateConverter {

    @Override
    public Project fromDto(CreateProjectDTO createProjectDTO) {
        return Project.builder()
                .title(createProjectDTO.title())
                .description(createProjectDTO.description())
                .establishmentId(createProjectDTO.establishmentId())
                .build();
    }

    @Override
    public CreateProjectDTO toDto(Project project) {
        return CreateProjectDTO.builder()
                .title(project.getTitle())
                .description(project.getDescription())
                .establishmentId(project.getEstablishmentId())
                .build();
    }
}
