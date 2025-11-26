package diaconat_mulhouse.fr.backend.application.converters.logType.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.UpdateLogTypeDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;

public interface LogTypeUpdateConverter extends Converter<UpdateLogTypeDTO, LogType> {
}
