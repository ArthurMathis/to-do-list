package diaconat_mulhouse.fr.backend.core.gateways.task.create;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverter;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;

/**
 * Class that implements the CreateTaskGateway
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class CreateTaskGatewayImpl implements CreateTaskGateway {

    protected TaskRepository taskRepository;
    protected CreateTaskConverter createTaskConverter;

    public CreateTaskGatewayImpl(TaskRepository taskRepository, CreateTaskConverter createTaskConverter) {
        this.taskRepository = taskRepository;
        this.createTaskConverter = createTaskConverter;
    }

    @Override
    public Long create(CreateTaskDTO createTaskDTO) {
        TaskJPA task = this.createTaskConverter.fromDto(createTaskDTO);
        TaskJPA savedTask = this.taskRepository.save(task);
        return savedTask.getId();
    }
}
