package diaconat_mulhouse.fr.backend.core.gateways.task.get;

import diaconat_mulhouse.fr.backend.domain.entities.Task;

/**
 * Interface that defines the gateway that return a task from its primary key
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface GetTaskGateway {

    /**
     * Public method that returns a task from its primary key
     *
     * @param id The primary key of the task
     * @return The task
     */
    public Task get(long id);
}
