package diaconat_mulhouse.fr.backend.core.converters.task.updateTask;

import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;

public class UpdateTaskConverterImpl implements UpdateTaskConverter{
    @Override
    public TaskJPA fromDto(UpdateTaskDTO updateTaskDTO) {
        return new TaskJPA(
            updateTaskDTO.getId(),
            updateTaskDTO.getTitled(),
            updateTaskDTO.isChecked()
        );
    }

    @Override
    public UpdateTaskDTO toDto(TaskJPA taskJPA) {
        return new UpdateTaskDTO(
            taskJPA.getId(),
            taskJPA.getTitled(),
            taskJPA.isChecked()
        );
    }
}
