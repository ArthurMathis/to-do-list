package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.AuthToken;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverter;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.LoginUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    private final UserJsonConverter userJsonConverter;
    private final UserCreateConverter userCreateConverter;
    private final UserUpdateConverter userUpdateConverter;

    public AuthToken authenticate(LoginUserDTO loginUserDTO) {
        return this.authenticateUserUseCase.execute(loginUserDTO);
    }

}
