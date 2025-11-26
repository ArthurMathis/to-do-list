package diaconat_mulhouse.fr.backend.application.usecases.log.index;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;

import java.util.List;

public interface IndexLogUseCase extends UseCase<Void, List<Log>> {
}
