package diaconat_mulhouse.fr.backend.application.converters.log.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.LogJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;

public interface LogJsonConverter extends Converter<LogJsonDTO, Log> {
}
