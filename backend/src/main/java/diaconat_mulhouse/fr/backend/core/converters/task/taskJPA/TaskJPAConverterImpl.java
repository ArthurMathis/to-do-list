package diaconat_mulhouse.fr.backend.core.converters.task.taskJPA;

import diaconat_mulhouse.fr.backend.domain.entities.Task;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;

public class TaskJPAConverterImpl implements TaskJPAConverter {
    @Override
    public TaskJPA fromDto(Task dto) {
        return new TaskJPA(
            dto.getId(),
            dto.getTitled(),
            dto.isChecked(),
            null
        );
    }

    @Override
    public Task toDto(TaskJPA model) {
        return new Task(
            model.getId(),
            model.getTitled(),
            model.isChecked()
        );
    }
}
