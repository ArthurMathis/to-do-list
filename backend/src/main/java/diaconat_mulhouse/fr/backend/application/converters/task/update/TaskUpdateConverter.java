package diaconat_mulhouse.fr.backend.application.converters.task.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.task.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.task.Task;

public interface TaskUpdateConverter extends Converter<UpdateTaskDTO, Task> {
}
