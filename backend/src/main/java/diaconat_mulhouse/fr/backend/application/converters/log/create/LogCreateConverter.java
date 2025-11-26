package diaconat_mulhouse.fr.backend.application.converters.log.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.CreateLogDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;

public interface LogCreateConverter extends Converter<CreateLogDTO, Log> {
}
