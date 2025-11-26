package diaconat_mulhouse.fr.backend.application.converters.log.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.UpdateLogDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;

public interface LogUpdateConverter extends Converter<UpdateLogDTO, Log> {
}
