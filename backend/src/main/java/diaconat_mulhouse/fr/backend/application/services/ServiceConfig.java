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
import diaconat_mulhouse.fr.backend.core.converters.establishment.createEstablishment.CreateEstablishmentConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.updateEstablishment.UpdateEstablishmentConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.createLogType.CreateLogTypeConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJson.LogTypeJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.updateLogType.UpdateLogTypeConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.createUser.CreateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.updateUser.UpdateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.userJson.UserJsonConverter;
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
        CreateLogTypeConverter createLogTypeConverter,
        UpdateLogTypeConverter updateLogTypeConverter
    ) {
        return new LogTypeServiceImpl(
            indexLogTypeUseCase,
            getLogTypeUseCase,
            createLogTypeUseCase,
            updateLogTypeUseCase,
            deleteLogTypeUseCase,
            logTypeJsonConverter,
            createLogTypeConverter,
            updateLogTypeConverter
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
        CreateEstablishmentConverter createEstablishmentConverter,
        UpdateEstablishmentConverter updateEstablishmentConverter
    ) {
        return new EstablishmentServiceImpl(
            indexEstablishmentUseCase,
            getEstablishmentUseCase,
            createEstablishmentUseCase,
            updateEstablishmentUseCase,
            deleteEstablishmentUseCase,
            establishmentJsonConverter,
            createEstablishmentConverter,
            updateEstablishmentConverter
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
        CreateUserConverter createUserConverter,
        UpdateUserConverter updateUserConverter
    ) {
        return new UserServiceImpl(
            indexUserUseCase,
            getUserUseCase,
            createUserUseCase,
            updateUserUseCase,
            deleteUserUseCase,
            authenticateUserUseCase,
            userJsonConverter,
            createUserConverter,
            updateUserConverter
        );
    }

}
