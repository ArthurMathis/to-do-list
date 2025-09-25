package diaconat_mulhouse.fr.backend.core.converters.task.taskJson;

import diaconat_mulhouse.fr.backend.application.DTOs.TaskJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.Task;

public class TaskJsonConverterImpl implements TaskJsonConverter {
    @Override
    public Task fromDto(TaskJsonDTO taskJsonDTO) {
        return new Task(
            taskJsonDTO.getId(),
            taskJsonDTO.getTitled(),
            taskJsonDTO.isChecked()
        );
    }

    @Override
    public TaskJsonDTO toDto(Task task) {
        return new TaskJsonDTO(
            task.getId(),
            task.getTitled(),
            task.isChecked()
        );
    }
}
