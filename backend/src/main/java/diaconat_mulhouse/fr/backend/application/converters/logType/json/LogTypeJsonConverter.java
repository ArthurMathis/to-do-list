package diaconat_mulhouse.fr.backend.application.converters.logType.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.LogTypeJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;

public interface LogTypeJsonConverter extends Converter<LogTypeJsonDTO, LogType> {
}
