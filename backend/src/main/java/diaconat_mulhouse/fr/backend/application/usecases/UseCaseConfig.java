package diaconat_mulhouse.fr.backend.application.usecases;

import diaconat_mulhouse.fr.backend.application.usecases.establishment.create.CreateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.create.CreateEstablishmentUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.delete.DeleteEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.delete.DeleteEstablishmentUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.get.GetEstablishmentUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.index.IndexEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.index.IndexEstablishmentUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.update.UpdateEstablishmentUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.establishment.update.UpdateEstablishmentUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.log.index.IndexLogUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.log.index.IndexLogUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.logType.create.CreateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.create.CreateLogTypeUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.logType.delete.DeleteLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.delete.DeleteLogTypeUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.logType.get.GetLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.get.GetLogTypeUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.logType.index.IndexLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.index.IndexLogTypeUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.logType.update.UpdateLogTypeUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.logType.update.UpdateLogTypeUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.create.CreateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.create.CreateUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.delete.DeleteUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.delete.DeleteUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.get.GetUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.get.GetUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.index.IndexUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.index.IndexUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.update.UpdateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.update.UpdateUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.create.CreateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.delete.DeleteEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.index.IndexEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.update.UpdateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.log.index.IndexLogGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.create.CreateLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.delete.DeleteLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.get.GetLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.index.IndexLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.update.UpdateLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.authenticate.AuthenticateUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.create.CreateUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.delete.DeleteUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.get.GetUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.index.IndexUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.update.UpdateUserGateway;
import diaconat_mulhouse.fr.backend.core.security.Jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCaseConfig {

    // * LOG TYPE * //
    @Bean
    public IndexLogTypeUseCase indexLogTypeUseCase(IndexLogTypeGateway indexLogTypeGateway) {
        return new IndexLogTypeUseCaseImpl(indexLogTypeGateway);
    }

    @Bean
    public GetLogTypeUseCase getLogTypeUseCase(GetLogTypeGateway getLogTypeGateway) {
        return new GetLogTypeUseCaseImpl(getLogTypeGateway);
    }

    @Bean
    public CreateLogTypeUseCase createLogTypeUseCase(CreateLogTypeGateway createLogTypeGateway) {
        return new CreateLogTypeUseCaseImpl(createLogTypeGateway);
    }

    @Bean
    public UpdateLogTypeUseCase updateLogTypeUseCase(UpdateLogTypeGateway updateLogTypeGateway) {
        return new UpdateLogTypeUseCaseImpl(updateLogTypeGateway);
    }

    @Bean
    public DeleteLogTypeUseCase deleteLogTypeUseCase(DeleteLogTypeGateway deleteLogTypeGateway) {
        return new DeleteLogTypeUseCaseImpl(deleteLogTypeGateway);
    }

    // * LOG * //
    @Bean
    public IndexLogUseCase indexLogUseCase(IndexLogGateway indexLogGateway) {
        return new IndexLogUseCaseImpl(indexLogGateway);
    }

    // * ESTABLISHMENTS  * //
    @Bean
    public IndexEstablishmentUseCase indexEstablishmentUseCase(IndexEstablishmentGateway indexEstablishmentGateway) {
        return new IndexEstablishmentUseCaseImpl(indexEstablishmentGateway);
    }

    @Bean
    public GetEstablishmentUseCase getEstablishmentUseCase(GetEstablishmentGateway getEstablishmentGateway) {
        return new GetEstablishmentUseCaseImpl(getEstablishmentGateway);
    }

    @Bean
    public CreateEstablishmentUseCase createEstablishmentUseCase(CreateEstablishmentGateway createEstablishmentGateway) {
        return new CreateEstablishmentUseCaseImpl(createEstablishmentGateway);
    }

    @Bean
    public UpdateEstablishmentUseCase updateEstablishmentUseCase(UpdateEstablishmentGateway updateEstablishmentGateway) {
        return new UpdateEstablishmentUseCaseImpl(updateEstablishmentGateway);
    }

    @Bean
    public DeleteEstablishmentUseCase deleteEstablishmentUseCase(DeleteEstablishmentGateway deleteEstablishmentGateway) {
        return new DeleteEstablishmentUseCaseImpl(deleteEstablishmentGateway);
    }

     // * USERS * //
    @Bean
    public IndexUserUseCase indexUserUseCase(IndexUserGateway indexUserGateway) {
        return new IndexUserUseCaseImpl(indexUserGateway);
    }

    @Bean
    public GetUserUseCase getUserUseCase(GetUserGateway getUserGateway) {
        return new GetUserUseCaseImpl(getUserGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(createUserGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UpdateUserGateway updateUserGateway) {
        return new UpdateUserUseCaseImpl(updateUserGateway);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(DeleteUserGateway deleteUserGateway) {
        return new DeleteUserUseCaseImpl(deleteUserGateway);
    }

    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(AuthenticateUserGateway authenticateUserGateway, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        return new AuthenticateUserUseCaseImpl(authenticateUserGateway, passwordEncoder, jwtProvider);
    }

    // * TASKS * //
}
