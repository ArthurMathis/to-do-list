package diaconat_mulhouse.fr.backend.core.converters.task.taskJson;

import diaconat_mulhouse.fr.backend.application.DTOs.TaskJsonDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.Task;

public interface TaskJsonConverter extends Converter<TaskJsonDTO, Task> {
}
