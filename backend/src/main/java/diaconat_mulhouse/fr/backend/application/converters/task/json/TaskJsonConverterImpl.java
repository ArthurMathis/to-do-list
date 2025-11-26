package diaconat_mulhouse.fr.backend.application.converters.task.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.TaskJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskJsonConverterImpl implements TaskJsonConverter {

    @Override
    public Task fromDto(TaskJsonDTO taskJsonDTO) {
        return Task.builder()
                .id(taskJsonDTO.id())
                .titled(taskJsonDTO.title())
                .description(taskJsonDTO.description())
                .checked(taskJsonDTO.checked())
                .usersId(taskJsonDTO.usersId())
                .createdAt(taskJsonDTO.createdAt())
                .build();
    }

    @Override
    public TaskJsonDTO toDto(Task task) {
        return TaskJsonDTO.builder()
                .id(task.getId())
                .title(task.getTitled())
                .description(task.getDescription())
                .checked(task.isChecked())
                .usersId(task.getUsersId())
                .createdAt(task.getCreatedAt())
                .build();
    }
}
