package diaconat_mulhouse.fr.backend.application.services.user;

import diaconat_mulhouse.fr.backend.application.DTOs.user.*;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.create.CreateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.delete.DeleteUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.get.GetUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.index.IndexUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.update.UpdateUserUseCase;
import diaconat_mulhouse.fr.backend.core.converters.user.createUser.CreateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.updateUser.UpdateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.userJson.UserJsonConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final IndexUserUseCase indexUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;

    private final UserJsonConverter userJsonConverter;
    private final CreateUserConverter createUserConverter;
    private final UpdateUserConverter updateUserConverter;

    public UserServiceImpl(
            IndexUserUseCase indexUserUseCase,
            GetUserUseCase getUserUseCase,
            CreateUserUseCase createUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase,
            AuthenticateUserUseCase authenticateUserUseCase,
            UserJsonConverter userJsonConverter,
            CreateUserConverter createUserConverter,
            UpdateUserConverter updateUserConverter
    ) {
        this.indexUserUseCase = indexUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;

        this.userJsonConverter = userJsonConverter;
        this.createUserConverter = createUserConverter;
        this.updateUserConverter = updateUserConverter;
    }

    @Override
    public List<UserJsonDTO> index() {
        return this.indexUserUseCase.execute(null).stream().map(this.userJsonConverter::toDto).toList();
    }

    @Override
    public UserJsonDTO get(Long aLong) {
        return this.userJsonConverter.toDto(this.getUserUseCase.execute(aLong));
    }

    @Override
    public Long create(CreateUserDTO createUserDTO) {
        return this.createUserUseCase.execute(this.createUserConverter.fromDto(createUserDTO));
    }

    @Override
    public void update(UpdateUserDTO updateUserDTO) {
        this.updateUserUseCase.execute(this.updateUserConverter.fromDto(updateUserDTO));
    }

    @Override
    public void delete(Long aLong) {
        this.deleteUserUseCase.execute(aLong);
    }

    @Override
    public AuthToken authenticate(LoginUserDTO loginUserDTO) {
        return this.authenticateUserUseCase.execute(loginUserDTO);
    }
}
