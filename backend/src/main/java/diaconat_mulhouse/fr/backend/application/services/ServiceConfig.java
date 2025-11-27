package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentServiceImpl;
import diaconat_mulhouse.fr.backend.application.services.user.UserService;
import diaconat_mulhouse.fr.backend.application.services.user.UserServiceImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverter;
import diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments.IndexEstablishmentsByUserIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public EstablishmentService establishmentService(
        IndexEstablishmentsByUserIdUseCase indexEstablishmentsByUserIdUseCase,
        EstablishmentJsonConverter establishmentJsonConverter,
        EstablishmentCreateConverter establishmentCreateConverter,
        EstablishmentUpdateConverter establishmentUpdateConverter
    ) {
        return new EstablishmentServiceImpl(
            indexEstablishmentsByUserIdUseCase,
            establishmentJsonConverter,
            establishmentCreateConverter,
            establishmentUpdateConverter
        );
    }

    @Bean
    public UserService userService(
        AuthenticateUserUseCase authenticateUserUseCase,
        UserJsonConverter userJsonConverter,
        UserCreateConverter userCreateConverter,
        UserUpdateConverter userUpdateConverter
    ) {
        return new UserServiceImpl(
            authenticateUserUseCase,
            userJsonConverter,
            userCreateConverter,
            userUpdateConverter
        );
    }

}
