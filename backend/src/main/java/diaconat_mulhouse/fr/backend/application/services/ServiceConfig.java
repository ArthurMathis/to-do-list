package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentServiceImpl;
import diaconat_mulhouse.fr.backend.application.services.logType.LogTypeService;
import diaconat_mulhouse.fr.backend.application.services.logType.LogTypeServiceImpl;
import diaconat_mulhouse.fr.backend.application.services.user.UserService;
import diaconat_mulhouse.fr.backend.application.services.user.UserServiceImpl;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.create.CreateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.delete.DeleteEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.index.IndexEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.update.UpdateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.create.CreateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.delete.DeleteLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.get.GetLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.index.IndexLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.update.UpdateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.create.CreateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.delete.DeleteUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.get.GetUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.index.IndexUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.update.UpdateUserUseCase;
import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.create.LogTypeCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.json.LogTypeJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.update.LogTypeUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public LogTypeService logTypeService(
        IndexLogTypeUseCase indexLogTypeUseCase,
        GetLogTypeUseCase getLogTypeUseCase,
        CreateLogTypeUseCase createLogTypeUseCase,
        UpdateLogTypeUseCase updateLogTypeUseCase,
        DeleteLogTypeUseCase deleteLogTypeUseCase,
        LogTypeJsonConverter logTypeJsonConverter,
        LogTypeCreateConverter logTypeCreateConverter,
        LogTypeUpdateConverter logTypeUpdateConverter
    ) {
        return new LogTypeServiceImpl(
            indexLogTypeUseCase,
            getLogTypeUseCase,
            createLogTypeUseCase,
            updateLogTypeUseCase,
            deleteLogTypeUseCase,
            logTypeJsonConverter,
                logTypeCreateConverter,
                logTypeUpdateConverter
        );
    }

    @Bean
    public EstablishmentService establishmentService(
        IndexEstablishmentUseCase indexEstablishmentUseCase,
        GetEstablishmentUseCase getEstablishmentUseCase,
        CreateEstablishmentUseCase createEstablishmentUseCase,
        UpdateEstablishmentUseCase updateEstablishmentUseCase,
        DeleteEstablishmentUseCase deleteEstablishmentUseCase,
        EstablishmentJsonConverter establishmentJsonConverter,
        EstablishmentCreateConverter establishmentCreateConverter,
        EstablishmentUpdateConverter establishmentUpdateConverter
    ) {
        return new EstablishmentServiceImpl(
            indexEstablishmentUseCase,
            getEstablishmentUseCase,
            createEstablishmentUseCase,
            updateEstablishmentUseCase,
            deleteEstablishmentUseCase,
            establishmentJsonConverter,
            establishmentCreateConverter,
            establishmentUpdateConverter
        );
    }

    @Bean
    public UserService userService(
        IndexUserUseCase indexUserUseCase,
        GetUserUseCase getUserUseCase,
        CreateUserUseCase createUserUseCase,
        UpdateUserUseCase updateUserUseCase,
        DeleteUserUseCase deleteUserUseCase,
        AuthenticateUserUseCase authenticateUserUseCase,
        UserJsonConverter userJsonConverter,
        UserCreateConverter userCreateConverter,
        UserUpdateConverter userUpdateConverter
    ) {
        return new UserServiceImpl(
            indexUserUseCase,
            getUserUseCase,
            createUserUseCase,
            updateUserUseCase,
            deleteUserUseCase,
            authenticateUserUseCase,
            userJsonConverter,
            userCreateConverter,
            userUpdateConverter
        );
    }

}
