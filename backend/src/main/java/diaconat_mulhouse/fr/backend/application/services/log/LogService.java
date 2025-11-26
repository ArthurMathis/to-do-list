package diaconat_mulhouse.fr.backend.application.services.log;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.CreateLogDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.log.LogJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.log.UpdateLogDTO;
import diaconat_mulhouse.fr.backend.application.services.CrudService;

public interface LogService extends CrudService<Long, LogJsonDTO, CreateLogDTO, UpdateLogDTO> {
}
