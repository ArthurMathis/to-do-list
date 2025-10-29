package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.create.CreateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.delete.DeleteEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.index.IndexEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.update.UpdateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.core.converters.establishment.createEstablishment.CreateEstablishmentConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.updateEstablishment.UpdateEstablishmentConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    private final IndexEstablishmentUseCase indexEstablishmentUseCase;
    private final GetEstablishmentUseCase getEstablishmentUseCase;
    private final CreateEstablishmentUseCase createEstablishmentUseCase;
    private final UpdateEstablishmentUseCase updateEstablishmentUseCase;
    private final DeleteEstablishmentUseCase deleteEstablishmentUseCase;

    private final EstablishmentJsonConverter establishmentJsonConverter;
    private final CreateEstablishmentConverter createEstablishmentConverter;
    private final UpdateEstablishmentConverter updateEstablishmentConverter;

    public EstablishmentServiceImpl(
            IndexEstablishmentUseCase indexEstablishmentUseCase,
            GetEstablishmentUseCase getEstablishmentUseCase,
            CreateEstablishmentUseCase  createEstablishmentUseCase,
            UpdateEstablishmentUseCase updateEstablishmentUseCase,
            DeleteEstablishmentUseCase deleteEstablishmentUseCase,
            EstablishmentJsonConverter establishmentJsonConverter,
            CreateEstablishmentConverter  createEstablishmentConverter,
            UpdateEstablishmentConverter updateEstablishmentConverter
    ) {
        this.indexEstablishmentUseCase = indexEstablishmentUseCase;
        this.getEstablishmentUseCase = getEstablishmentUseCase;
        this.createEstablishmentUseCase = createEstablishmentUseCase;
        this.updateEstablishmentUseCase = updateEstablishmentUseCase;
        this.deleteEstablishmentUseCase = deleteEstablishmentUseCase;

        this.establishmentJsonConverter = establishmentJsonConverter;
        this.createEstablishmentConverter = createEstablishmentConverter;
        this.updateEstablishmentConverter = updateEstablishmentConverter;
    }

    @Override
    public List<EstablishmentJsonDTO> index() {
        return this.indexEstablishmentUseCase.execute(null).stream().map(this.establishmentJsonConverter::toDto).toList();
    }

    @Override
    public EstablishmentJsonDTO get(Long id) {
        return this.establishmentJsonConverter.toDto(this.getEstablishmentUseCase.execute(id));
    }

    @Override
    public Long create(CreateEstablishmentDTO createEstablishmentDTO) {
        return this.createEstablishmentUseCase.execute(this.createEstablishmentConverter.fromDto(createEstablishmentDTO));
    }

    @Override
    public void update(UpdateEstablishmentDTO updateEstablishmentDTO) {
        this.updateEstablishmentUseCase.execute(this.updateEstablishmentConverter.fromDto(updateEstablishmentDTO));
    }

    @Override
    public void delete(Long id) {
        this.deleteEstablishmentUseCase.execute(id);
    }
}
