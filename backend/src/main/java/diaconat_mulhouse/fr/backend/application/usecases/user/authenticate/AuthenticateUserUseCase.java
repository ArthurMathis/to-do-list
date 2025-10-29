package diaconat_mulhouse.fr.backend.application.usecases.user.authenticate;

import diaconat_mulhouse.fr.backend.application.DTOs.user.AuthToken;
import diaconat_mulhouse.fr.backend.application.DTOs.user.LoginUserDTO;
import diaconat_mulhouse.fr.backend.application.usecases.UseCase;

public interface AuthenticateUserUseCase extends UseCase<LoginUserDTO, AuthToken> {
}
