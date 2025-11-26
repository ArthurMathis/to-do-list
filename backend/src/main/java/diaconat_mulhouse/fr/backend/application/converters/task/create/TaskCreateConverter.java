package diaconat_mulhouse.fr.backend.application.converters.task.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;

public interface TaskCreateConverter extends Converter<CreateTaskDTO, Task> {
}
