package diaconat_mulhouse.fr.backend.application.usecases.task.create;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.core.gateways.task.create.CreateTaskGateway;

/**
 * Class that implements the CreateTaskUseCase
 *
 * @author Arthur MMATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    protected CreateTaskGateway createTaskGateway;

    public CreateTaskUseCaseImpl(CreateTaskGateway createTaskGateway) {
        this.createTaskGateway = createTaskGateway;
    }

    @Override
    public Long execute(CreateTaskDTO createTaskDTO) {
        return this.createTaskGateway.create(createTaskDTO);
    }
}
