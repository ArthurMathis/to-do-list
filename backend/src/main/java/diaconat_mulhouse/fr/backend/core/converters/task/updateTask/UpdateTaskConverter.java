package diaconat_mulhouse.fr.backend.core.converters.task.updateTask;

import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;

public interface UpdateTaskConverter extends Converter<UpdateTaskDTO, TaskJPA> {
}
