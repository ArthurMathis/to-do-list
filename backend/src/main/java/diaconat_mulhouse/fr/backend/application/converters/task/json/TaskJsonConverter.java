package diaconat_mulhouse.fr.backend.application.converters.task.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.TaskJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;

public interface TaskJsonConverter extends Converter<TaskJsonDTO, Task> {
}
