package diaconat_mulhouse.fr.backend.core.gateways.task.create;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;

public interface CreateTaskGateway {

    public Long create(CreateTaskDTO createTaskDTO);
}
