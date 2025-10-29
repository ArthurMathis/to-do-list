package diaconat_mulhouse.fr.backend.application.usecases.user.index;

import diaconat_mulhouse.fr.backend.application.usecases.UseCase;
import diaconat_mulhouse.fr.backend.core.gateways.user.index.IndexUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

import java.util.List;

public interface IndexUserUseCase extends UseCase<Void, List<User>> {
}
