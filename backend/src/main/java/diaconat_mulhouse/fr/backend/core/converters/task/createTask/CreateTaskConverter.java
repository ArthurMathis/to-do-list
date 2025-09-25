package diaconat_mulhouse.fr.backend.core.converters.task.createTask;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;

public interface CreateTaskConverter extends Converter<CreateTaskDTO, TaskJPA> {
}
