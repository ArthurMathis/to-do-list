package diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

import java.util.List;

public interface IndexEstablishmentsByUserIdUseCase extends UseCase<Long, List<Establishment>> {
}
