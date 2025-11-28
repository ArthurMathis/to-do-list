package diaconat_mulhouse.fr.backend.application.usecases.establishment.get;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.GetEstablishmentDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;

@AllArgsConstructor
public class GetEstablishmentUseCaseImpl implements GetEstablishmentUseCase {

    private final GetEstablishmentGateway getEstablishmentGateway;

    @Override
    public Establishment execute(GetEstablishmentDTO getEstablishmentDTO) {
        Establishment fetchedEstablishment = this.getEstablishmentGateway.get(getEstablishmentDTO.establishmentId());
        if(!fetchedEstablishment.getUsersId().contains(getEstablishmentDTO.userId())) {
            throw new AccessDeniedException("The user : " + getEstablishmentDTO.userId() + " doesn't work in establishment : " + getEstablishmentDTO.userId() + ".");
        }
        return fetchedEstablishment;
    }
}
