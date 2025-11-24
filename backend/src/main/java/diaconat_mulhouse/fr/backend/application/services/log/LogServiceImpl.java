package diaconat_mulhouse.fr.backend.application.services.log;

import diaconat_mulhouse.fr.backend.application.DTOs.log.CreateLogDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.log.LogJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.log.UpdateLogDTO;

import java.util.List;

public class LogServiceImpl implements LogService {

    @Override
    public List<LogJsonDTO> index() {
        return List.of();
    }

    @Override
    public LogJsonDTO get(Long aLong) {
        return null;
    }

    @Override
    public Long create(CreateLogDTO createLogDTO) {
        return 0L;
    }

    @Override
    public void update(UpdateLogDTO updateLogDTO) {

    }

    @Override
    public void delete(Long aLong) {

    }

}
