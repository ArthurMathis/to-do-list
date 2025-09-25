package diaconat_mulhouse.fr.backend.core.gateways.task.update;

import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;

public interface UpdateTaskGateway {

    public void update(UpdateTaskDTO updateTaskDTO);
}
