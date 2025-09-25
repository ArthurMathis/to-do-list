package diaconat_mulhouse.fr.backend.core.gateways.task.index;

import diaconat_mulhouse.fr.backend.domain.entities.Task;

import java.util.List;

/**
 * Interface that defines the gateway that return the completed list of task
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface IndexTaskGateway {

    /**
     * Public method that returns the completed list of task
     *
     * @return The list of task
     */
    public List<Task> getAll();
}
