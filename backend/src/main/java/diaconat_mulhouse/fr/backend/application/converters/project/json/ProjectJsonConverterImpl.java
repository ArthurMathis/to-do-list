package diaconat_mulhouse.fr.backend.application.converters.project.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.ProjectJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectJsonConverterImpl implements ProjectJsonConverter {

    @Override
    public Project fromDto(ProjectJsonDTO projectJsonDTO) {
        return Project.builder()
                .id(projectJsonDTO.id())
                .title(projectJsonDTO.title())
                .description(projectJsonDTO.description())
                .establishmentId(projectJsonDTO.establishmentId())
                .tasksId(projectJsonDTO.tasksId())
                .createdAt(projectJsonDTO.createdAt())
                .build();
    }

    @Override
    public ProjectJsonDTO toDto(Project project) {
        return ProjectJsonDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .establishmentId(project.getEstablishmentId())
                .tasksId(project.getTasksId())
                .createdAt(project.getCreatedAt())
                .build();
    }
}
