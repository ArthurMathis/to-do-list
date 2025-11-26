package diaconat_mulhouse.fr.backend.application.converters.project.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;
import diaconat_mulhouse.fr.backend.domain.entities.project.ProjectJPA;
import diaconat_mulhouse.fr.backend.domain.entities.task.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ProjectJPAConverterImpl implements ProjectJPAConverter {

    private final EstablishmentRepository establishmentRepository;
    private final TaskRepository taskRepository;

    public ProjectJPAConverterImpl(EstablishmentRepository establishmentRepository, TaskRepository taskRepository) {
        this.establishmentRepository = establishmentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public ProjectJPA fromDto(Project project) {
        EstablishmentJPA establishmentJPA = this.establishmentRepository.findById(project.getId()).orElseThrow(() -> {
            return new EntityNotFoundException("Establishment : " + project.getId() + ", not found.");
        });

        return ProjectJPA.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .establishment(establishmentJPA)
                .tasks(this.taskRepository.findAllById(project.getTasksId()))
                .createdAt(project.getCreatedAt())
                .build();
    }

    @Override
    public Project toDto(ProjectJPA projectJPA) {
        return Project.builder()
                .id(projectJPA.getId())
                .title(projectJPA.getTitle())
                .description(projectJPA.getDescription())
                .establishmentId(projectJPA.getEstablishment().getId())
                .tasksId(projectJPA.getTasks().stream().map(TaskJPA::getId).toList())
                .createdAt(projectJPA.getCreatedAt())
                .build();
    }
}
