package diaconat_mulhouse.fr.backend.core.gateways.task.index;

import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Task;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;

import java.util.List;

/**
 * Class that implements the IndexTaskGateway
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class IndexTaskGatewayImpl implements IndexTaskGateway {

    protected TaskRepository taskRepository;
    protected TaskJPAConverter taskJPAConverter;

    public IndexTaskGatewayImpl(TaskRepository taskRepository, TaskJPAConverter taskJPAConverter) {
        this.taskRepository = taskRepository;
        this.taskJPAConverter = taskJPAConverter;
    }

    @Override
    public List<Task> getAll() {
        List<TaskJPA> tasks = this.taskRepository.findAll();
        return tasks.stream().map(this.taskJPAConverter::toDto).toList();
    }
}
