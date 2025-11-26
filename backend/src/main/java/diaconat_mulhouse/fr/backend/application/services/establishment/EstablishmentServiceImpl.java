package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.create.CreateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.delete.DeleteEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.index.IndexEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.update.UpdateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
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
    private final EstablishmentCreateConverter establishmentCreateConverter;
    private final EstablishmentUpdateConverter establishmentUpdateConverter;

    public EstablishmentServiceImpl(
            IndexEstablishmentUseCase indexEstablishmentUseCase,
            GetEstablishmentUseCase getEstablishmentUseCase,
            CreateEstablishmentUseCase  createEstablishmentUseCase,
            UpdateEstablishmentUseCase updateEstablishmentUseCase,
            DeleteEstablishmentUseCase deleteEstablishmentUseCase,
            EstablishmentJsonConverter establishmentJsonConverter,
            EstablishmentCreateConverter establishmentCreateConverter,
            EstablishmentUpdateConverter establishmentUpdateConverter
    ) {
        this.indexEstablishmentUseCase = indexEstablishmentUseCase;
        this.getEstablishmentUseCase = getEstablishmentUseCase;
        this.createEstablishmentUseCase = createEstablishmentUseCase;
        this.updateEstablishmentUseCase = updateEstablishmentUseCase;
        this.deleteEstablishmentUseCase = deleteEstablishmentUseCase;

        this.establishmentJsonConverter = establishmentJsonConverter;
        this.establishmentCreateConverter = establishmentCreateConverter;
        this.establishmentUpdateConverter = establishmentUpdateConverter;
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
        return this.createEstablishmentUseCase.execute(this.establishmentCreateConverter.fromDto(createEstablishmentDTO));
    }

    @Override
    public void update(UpdateEstablishmentDTO updateEstablishmentDTO) {
        this.updateEstablishmentUseCase.execute(this.establishmentUpdateConverter.fromDto(updateEstablishmentDTO));
    }

    @Override
    public void delete(Long id) {
        this.deleteEstablishmentUseCase.execute(id);
    }
}
