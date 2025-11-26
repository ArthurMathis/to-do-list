package diaconat_mulhouse.fr.backend.application.services.logType;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.CreateLogTypeDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.LogTypeJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.UpdateLogTypeDTO;
import diaconat_mulhouse.fr.backend.application.usecases.logType.create.CreateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.delete.DeleteLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.get.GetLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.index.IndexLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.update.UpdateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.converters.logType.create.LogTypeCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.json.LogTypeJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.update.LogTypeUpdateConverter;

import java.util.List;

public class LogTypeServiceImpl implements LogTypeService {

    private final IndexLogTypeUseCase indexLogTypeUseCase;
    private final GetLogTypeUseCase getLogTypeUseCase;
    private final CreateLogTypeUseCase createLogTypeUseCase;
    private final UpdateLogTypeUseCase updateLogTypeUseCase;
    private final DeleteLogTypeUseCase deleteLogTypeUseCase;

    private final LogTypeJsonConverter logTypeJsonConverter;
    private final LogTypeCreateConverter logTypeCreateConverter;
    private final LogTypeUpdateConverter logTypeUpdateConverter;

    public LogTypeServiceImpl(
            IndexLogTypeUseCase indexLogTypeUseCase,
            GetLogTypeUseCase getLogTypeUseCase,
            CreateLogTypeUseCase createLogTypeUseCase,
            UpdateLogTypeUseCase updateLogTypeUseCase,
            DeleteLogTypeUseCase deleteLogTypeUseCase,
            LogTypeJsonConverter logTypeJsonConverter,
            LogTypeCreateConverter logTypeCreateConverter,
            LogTypeUpdateConverter logTypeUpdateConverter
    ) {
        this.indexLogTypeUseCase = indexLogTypeUseCase;
        this.getLogTypeUseCase = getLogTypeUseCase;
        this.createLogTypeUseCase = createLogTypeUseCase;
        this.updateLogTypeUseCase = updateLogTypeUseCase;
        this.deleteLogTypeUseCase = deleteLogTypeUseCase;
        this.logTypeJsonConverter = logTypeJsonConverter;
        this.logTypeCreateConverter = logTypeCreateConverter;
        this.logTypeUpdateConverter = logTypeUpdateConverter;
    }

    @Override
    public List<LogTypeJsonDTO> index() {
        return this.indexLogTypeUseCase.execute(null).stream().map(this.logTypeJsonConverter::toDto).toList();
    }

    @Override
    public LogTypeJsonDTO get(Long aLong) {
        return this.logTypeJsonConverter.toDto(this.getLogTypeUseCase.execute(aLong));
    }

    @Override
    public Long create(CreateLogTypeDTO createLogTypeDTO) {
        return this.createLogTypeUseCase.execute(this.logTypeCreateConverter.fromDto(createLogTypeDTO));
    }

    @Override
    public void update(UpdateLogTypeDTO updateLogTypeDTO) {
        this.updateLogTypeUseCase.execute(this.logTypeUpdateConverter.fromDto(updateLogTypeDTO));
    }

    @Override
    public void delete(Long aLong) {
        this.deleteLogTypeUseCase.execute(aLong);
    }

}
