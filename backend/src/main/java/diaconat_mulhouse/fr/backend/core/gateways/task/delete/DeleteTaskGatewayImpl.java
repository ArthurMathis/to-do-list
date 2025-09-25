package diaconat_mulhouse.fr.backend.core.gateways.task.delete;

import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;

public class DeleteTaskGatewayImpl implements DeleteTaskGateway {

    protected TaskRepository taskRepository;

    public DeleteTaskGatewayImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void delete(long id) {
        this.taskRepository.deleteById(id);
    }
}
