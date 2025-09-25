package diaconat_mulhouse.fr.backend.application.usecases.task.update;

import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.core.gateways.task.update.UpdateTaskGateway;

/**
 * Class that implements the UpdateTaskUseCase
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    protected UpdateTaskGateway updateTaskGateway;

    public UpdateTaskUseCaseImpl(UpdateTaskGateway updateTaskGateway) {
        this.updateTaskGateway = updateTaskGateway;
    }

    @Override
    public Void execute(UpdateTaskDTO updateTaskDTO) {
        this.updateTaskGateway.update(updateTaskDTO);
        return null;
    }
}
