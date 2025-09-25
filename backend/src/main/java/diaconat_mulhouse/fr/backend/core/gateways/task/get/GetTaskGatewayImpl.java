package diaconat_mulhouse.fr.backend.core.gateways.task.get;

import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Task;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * Class that implements the GetTaskGateway
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class GetTaskGatewayImpl implements GetTaskGateway {

    protected TaskRepository taskRepository;
    protected TaskJPAConverter taskJPAConverter;

    public GetTaskGatewayImpl(TaskRepository taskRepository,  TaskJPAConverter taskJPAConverter) {
        this.taskRepository = taskRepository;
        this.taskJPAConverter = taskJPAConverter;
    }

    @Override
    public Task get(long id) {
        TaskJPA fetchedTask = this.taskRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("The task with id " + id + " does not exist");
        });

        return this.taskJPAConverter.toDto(fetchedTask);
    }
}
