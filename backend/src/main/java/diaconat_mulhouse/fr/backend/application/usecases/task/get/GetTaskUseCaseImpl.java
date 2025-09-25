package diaconat_mulhouse.fr.backend.application.usecases.task.get;

import diaconat_mulhouse.fr.backend.core.gateways.task.get.GetTaskGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Task;

/**
 * Class that implements the GetTaskUseCase
 *
 * @author Arthur MMATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class GetTaskUseCaseImpl implements GetTaskUseCase {

    protected GetTaskGateway getTaskGateway;

    public GetTaskUseCaseImpl(GetTaskGateway getTaskGateway) {
        this.getTaskGateway = getTaskGateway;
    }

    @Override
    public Task execute(Long id) {
        return this.getTaskGateway.get(id);
    }
}
