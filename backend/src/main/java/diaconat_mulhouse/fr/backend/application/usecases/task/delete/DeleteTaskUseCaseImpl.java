package diaconat_mulhouse.fr.backend.application.usecases.task.delete;

import diaconat_mulhouse.fr.backend.core.gateways.task.delete.DeleteTaskGateway;

/**
 * Class that implements the DeleteTaskUseCase
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class DeleteTaskUseCaseImpl implements  DeleteTaskUseCase {

    protected DeleteTaskGateway deleteTaskGateway;

    public DeleteTaskUseCaseImpl(DeleteTaskGateway deleteTaskGateway) {
        this.deleteTaskGateway = deleteTaskGateway;
    }

    @Override
    public Void execute(Long id) {
        this.deleteTaskGateway.delete(id);
        return null;
    }
}
