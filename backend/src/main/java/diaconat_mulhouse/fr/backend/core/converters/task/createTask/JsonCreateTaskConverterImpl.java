package diaconat_mulhouse.fr.backend.core.converters.task.createTask;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.JsonCreateTaskDTO;

public class JsonCreateTaskConverterImpl implements JsonCreateTaskConverter {
    @Override
    public CreateTaskDTO fromDto(JsonCreateTaskDTO jsonCreateTaskDTO) {
        return new CreateTaskDTO(
                jsonCreateTaskDTO.getTitled()
        );
    }

    @Override
    public JsonCreateTaskDTO toDto(CreateTaskDTO createTaskDTO) {
        return null;
    }
}
