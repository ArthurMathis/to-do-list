package diaconat_mulhouse.fr.backend.application.usecases.task.list;

import diaconat_mulhouse.fr.backend.core.gateways.task.index.IndexTaskGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Task;

import java.util.List;

/**
 * Class that implements the ListTaskUseCase
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class ListTaskUseCaseImpl implements ListTaskUseCase {

    protected IndexTaskGateway indexTaskGateway;

    public ListTaskUseCaseImpl (IndexTaskGateway indexTaskGateway) {
        this.indexTaskGateway = indexTaskGateway;
    }

    @Override
    public List<Task> execute(Void request) {
        return this.indexTaskGateway.getAll();
    }
}