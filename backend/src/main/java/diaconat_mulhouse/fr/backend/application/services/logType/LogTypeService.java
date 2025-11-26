package diaconat_mulhouse.fr.backend.application.services.logType;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.CreateLogTypeDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.LogTypeJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.UpdateLogTypeDTO;
import diaconat_mulhouse.fr.backend.application.services.CrudService;

public interface LogTypeService extends CrudService<Long, LogTypeJsonDTO, CreateLogTypeDTO, UpdateLogTypeDTO> {
}
