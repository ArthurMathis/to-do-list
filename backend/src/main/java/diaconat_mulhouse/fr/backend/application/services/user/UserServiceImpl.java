package diaconat_mulhouse.fr.backend.application.services.user;

import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.AuthToken;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverter;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.LoginUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UserJsonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    private final UserJsonConverter userJsonConverter;
    private final UserCreateConverter userCreateConverter;
    private final UserUpdateConverter userUpdateConverter;

    @Override
    public List<UserJsonDTO> index() {
        // return this.indexUserUseCase.execute(null).stream().map(this.userJsonConverter::toDto).toList();
        return List.of();
    }

    @Override
    public UserJsonDTO get(Long aLong) {
        // return this.userJsonConverter.toDto(this.getUserUseCase.execute(aLong));
        return null;
    }

    @Override
    public Long create(CreateUserDTO createUserDTO) {
        // return this.createUserUseCase.execute(this.userCreateConverter.fromDto(createUserDTO));
        return 0L;
    }

    @Override
    public void update(UpdateUserDTO updateUserDTO) {
        // this.updateUserUseCase.execute(this.userUpdateConverter.fromDto(updateUserDTO));
    }

    @Override
    public void delete(Long aLong) {
        // this.deleteUserUseCase.execute(aLong);
    }

    @Override
    public AuthToken authenticate(LoginUserDTO loginUserDTO) {
        return this.authenticateUserUseCase.execute(loginUserDTO);
    }

}
