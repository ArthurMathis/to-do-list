package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments.IndexEstablishmentsByUserIdUseCase;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.GetEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstablishmentService{

    private final GetEstablishmentUseCase getEstablishmentUseCase;
    private final IndexEstablishmentsByUserIdUseCase indexEstablishmentsByUserIdUseCase;

    private final EstablishmentJsonConverter establishmentJsonConverter;
    private final EstablishmentCreateConverter establishmentCreateConverter;
    private final EstablishmentUpdateConverter establishmentUpdateConverter;

    public EstablishmentJsonDTO get(long userId, long establishmentId) {
        return this.establishmentJsonConverter.toDto(this.getEstablishmentUseCase.execute(new GetEstablishmentDTO(userId, establishmentId)));
    }

    public List<EstablishmentJsonDTO> indexByUserId(Long userId) {
        return this.indexEstablishmentsByUserIdUseCase.execute(userId).stream().map(this.establishmentJsonConverter::toDto).toList();
    }

}
