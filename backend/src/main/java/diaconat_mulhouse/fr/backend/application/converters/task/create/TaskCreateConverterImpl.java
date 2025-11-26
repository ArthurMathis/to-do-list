package diaconat_mulhouse.fr.backend.application.converters.task.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateConverterImpl implements TaskCreateConverter {

    @Override
    public Task fromDto(CreateTaskDTO createTaskDTO) {
        return Task.builder()
                .titled(createTaskDTO.title())
                .description(createTaskDTO.description())
                .projectId(createTaskDTO.projectId())
                .build();
    }

    @Override
    public CreateTaskDTO toDto(Task task) {
        return CreateTaskDTO.builder()
                .title(task.getTitled())
                .description(task.getDescription())
                .projectId(task.getProjectId())
                .build();
    }
}
