package diaconat_mulhouse.fr.backend.application.usecases.establishment.get;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.GetEstablishmentDTO;

public interface GetEstablishmentUseCase extends UseCase<GetEstablishmentDTO, Establishment> {
}
