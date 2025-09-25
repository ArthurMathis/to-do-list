package diaconat_mulhouse.fr.backend.core.converters.task.createTask;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;

public class CreateTaskConverterImpl implements CreateTaskConverter {
    @Override
    public TaskJPA fromDto(CreateTaskDTO createTaskDTO) {
        return new TaskJPA(createTaskDTO.getTitled());
    }

    @Override
    public CreateTaskDTO toDto(TaskJPA taskJPA) {
        return new CreateTaskDTO(taskJPA.getTitled());
    }
}
