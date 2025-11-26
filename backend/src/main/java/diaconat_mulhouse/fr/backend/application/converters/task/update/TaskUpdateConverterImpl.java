package diaconat_mulhouse.fr.backend.application.converters.task.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdateConverterImpl implements TaskUpdateConverter {

    @Override
    public Task fromDto(UpdateTaskDTO updateTaskDTO) {
        return Task.builder()
                .id(updateTaskDTO.id())
                .titled(updateTaskDTO.title())
                .description(updateTaskDTO.description())
                .projectId(updateTaskDTO.projectId())
                .build();
    }

    @Override
    public UpdateTaskDTO toDto(Task task) {
        return UpdateTaskDTO.builder()
                .id(task.getId())
                .title(task.getTitled())
                .description(task.getDescription())
                .projectId(task.getProjectId())
                .build();
    }
}
