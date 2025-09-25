package diaconat_mulhouse.fr.backend.core.gateways.task.update;

import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Task;
import diaconat_mulhouse.fr.backend.domain.entities.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * Class that implements the UpdateTaskGateway
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class UpdateTaskGatewayImpl implements UpdateTaskGateway {

    protected TaskRepository taskRepository;
    protected TaskJPAConverter taskJPAConverter;

    public UpdateTaskGatewayImpl(TaskRepository taskRepository,  TaskJPAConverter taskJPAConverter) {
        this.taskRepository = taskRepository;
        this.taskJPAConverter = taskJPAConverter;
    }

    @Override
    public void update(UpdateTaskDTO updateTaskDTO) {
        TaskJPA fetchedTask = this.taskRepository.findById(updateTaskDTO.getId()).orElseThrow(() -> {
            return new EntityNotFoundException("The task with id " + updateTaskDTO.getId() + " does not exist");
        });
        Task taskToUpdate = this.taskJPAConverter.toDto(fetchedTask);
        taskToUpdate.setTitled(updateTaskDTO.getTitled());
        TaskJPA updatedTask = this.taskJPAConverter.fromDto(taskToUpdate);
        this.taskRepository.save(updatedTask);
    }
}
