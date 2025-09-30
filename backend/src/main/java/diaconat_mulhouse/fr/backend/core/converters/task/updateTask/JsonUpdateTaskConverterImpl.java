package diaconat_mulhouse.fr.backend.core.converters.task.updateTask;

import diaconat_mulhouse.fr.backend.application.DTOs.JsonUpdateTaskDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;

public class JsonUpdateTaskConverterImpl implements JsonUpdateTaskConverter {
    @Override
    public UpdateTaskDTO fromDto(JsonUpdateTaskDTO jsonUpdateTaskDTO) {
        return new UpdateTaskDTO(
            jsonUpdateTaskDTO.getId(),
            jsonUpdateTaskDTO.getTitled(),
            jsonUpdateTaskDTO.isChecked()
        );
    }

    @Override
    public JsonUpdateTaskDTO toDto(UpdateTaskDTO updateTaskDTO) {
        return new JsonUpdateTaskDTO(
            updateTaskDTO.getId(),
            updateTaskDTO.getTitled(),
            updateTaskDTO.isChecked()
        );
    }
}
