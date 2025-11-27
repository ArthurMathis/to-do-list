package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
import diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments.IndexEstablishmentsByUserIdUseCase;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService{

    private final IndexEstablishmentsByUserIdUseCase indexEstablishmentsByUserIdUseCase;

    private final EstablishmentJsonConverter establishmentJsonConverter;
    private final EstablishmentCreateConverter establishmentCreateConverter;
    private final EstablishmentUpdateConverter establishmentUpdateConverter;

    @Override
    public List<EstablishmentJsonDTO> index() {
        return List.of();
    }

    @Override
    public List<EstablishmentJsonDTO> indexByUserId(Long userId) {
        return this.indexEstablishmentsByUserIdUseCase.execute(userId).stream().map(this.establishmentJsonConverter::toDto).toList();
    }

    @Override
    public EstablishmentJsonDTO get(Long aLong) {
        return null;
    }

    @Override
    public Long create(CreateEstablishmentDTO createEstablishmentDTO) {
        return 0L;
    }

    @Override
    public void update(UpdateEstablishmentDTO updateEstablishmentDTO) {

    }

    @Override
    public void delete(Long aLong) {

    }

}
