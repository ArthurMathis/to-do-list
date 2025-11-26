package diaconat_mulhouse.fr.backend.application.converters.project.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.UpdateProjectDTO;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectUpdateConverterImpl implements ProjectUpdateConverter {

    @Override
    public Project fromDto(UpdateProjectDTO updateProjectDTO) {
        return Project.builder()
                .id(updateProjectDTO.id())
                .title(updateProjectDTO.title())
                .description(updateProjectDTO.description())
                .establishmentId(updateProjectDTO.establishmentId())
                .tasksId(updateProjectDTO.tasksId())
                .build();
    }

    @Override
    public UpdateProjectDTO toDto(Project project) {
        return UpdateProjectDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .establishmentId(project.getEstablishmentId())
                .tasksId(project.getTasksId())
                .build();
    }
}
