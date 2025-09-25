package diaconat_mulhouse.fr.backend.application.usecases.task.list;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.domain.entities.Task;

import java.util.List;

/**
 * Interface that returns the completed list of task
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface ListTaskUseCase extends UseCase<Void, List<Task>> {

    /**
     * Public method that returns the completed list of task.
     *
     * @return The completed list of task
     */
    default List<Task> execute() {
        return execute(null);
    }
}
