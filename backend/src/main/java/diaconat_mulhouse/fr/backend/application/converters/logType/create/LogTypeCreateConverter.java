package diaconat_mulhouse.fr.backend.application.converters.logType.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.CreateLogTypeDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;

public interface LogTypeCreateConverter extends Converter<CreateLogTypeDTO, LogType> {
}
